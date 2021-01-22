package com.bohan.controller;


import com.bohan.entity.Charge;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.service.StripeService;
import com.bohan.service.impl.ChargeServiceImpl;
import com.bohan.service.impl.CourseStudentServiceImpl;
import com.bohan.utils.ResultData;
import com.bohan.vo.req.PaymentRepVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Api(tags = "views")
@RequestMapping("/index")
public class IndexController {

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    @Autowired
    private StripeService stripeService;

    @Autowired
    private CourseStudentServiceImpl courseStudentService;

    @Autowired
    private ChargeServiceImpl chargeService;



    @GetMapping("/error")
    public String errorPage(Model model, String message){
        model.addAttribute("message",message);
        return "error";
    }

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping("/success/{customerId}")
    public String finishedPage(Model model,@PathVariable("customerId") String customerId){
        model.addAttribute("customerId",customerId);
        return "finished";
    }




    @PostMapping("/charge")
    @CrossOrigin
    public String chargePage(Model model,PaymentRepVO paymentRepVO) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        model.addAttribute("courseInfo",paymentRepVO);
        System.out.println(paymentRepVO.getStudentId());
        System.out.println(paymentRepVO.getName());
        return "charge";
    }




    @PostMapping("/create-customer")
    public @ResponseBody
    ResultData createCustomer(Model model, String studentId, String token, String price, String courseId, String userId, String email) {
        //validate data
        if (studentId == null || price == null || courseId == null || userId == null){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATA_MISSING);
        }

        if (token == null) {
            ResultData result = new ResultData<>(BaseResponseCodeImp.PAYMENT_ERROR_TOKENMISSING);
            return result;

        }
        //create custom
        String customerId = stripeService.createCustomer(email, token);

        // register courses
        courseStudentService.registerCourse(studentId, courseId);

        // record customerId and amount
        Charge charge = new Charge();
        charge.setId(UUID.randomUUID().toString());
        charge.setStatus("1");
        charge.setToken(customerId);
        charge.setpId(userId);
        charge.setAmount(price);
        charge.setcId(courseId);
        charge.setsId(studentId);
        charge.setCreateTime(new Date().toString());
        chargeService.addNewCharge(charge);

//        Charge charge = stripeService.createCharge(studentId, token, Integer.parseInt(price)*100, userId, courseId);
//        if (charge == null) {
//            ResultData result = new ResultData<>(BaseResponseCodeImp.PAYMENT_ERROR_CHARGE_ERROR);
//            return result;
//        }
//
//        // You may want to store charge id along with order information
//        model.addAttribute("Success! Your charge id is " + charge.getId() );

        ResultData result = ResultData.success();

        result.setData(customerId);
        return result;
    }

    @GetMapping("/create-charge/{courseId}")
    @ResponseBody
    @Transactional
    public ResultData triggerChargesByCourseId(@PathVariable("courseId") String courseId){

        // get all chagre id
        List<String> charges = chargeService.queryByCourseId(courseId);
        System.out.println(charges.toString());
        // record
        chargeService.triggerCourse(charges);


        for (String chargeId : charges){
            Charge charge = chargeService.queryById(chargeId);
            String stripeChargeId = stripeService.createCharge(charge.getsId(), charge.getToken(), Integer.parseInt(charge.getAmount()) * 100, charge.getpId(), charge.getpId());
            if (stripeChargeId == null) {
                ResultData result = new ResultData<>(BaseResponseCodeImp.PAYMENT_ERROR_CHARGE_ERROR);
                return result;
            }
        }

        return ResultData.success();
    }

}
