package com.bohan.controller;


import com.bohan.entity.Charge;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.service.StripeService;
import com.bohan.utils.Response;
import com.bohan.vo.req.PaymentRepVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(tags = "views")
@RequestMapping("/index")
public class IndexController {

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    @Autowired
    private StripeService stripeService;



    @GetMapping("/subscription")
    public String subscriptionPage(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        return "subscription";
    }




    @PostMapping("/charge")
    @CrossOrigin
    public String chargePage(Model model,PaymentRepVO paymentRepVO) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        model.addAttribute("courseInfo",paymentRepVO);
        System.out.println(paymentRepVO.getId());
        System.out.println(paymentRepVO.getName());
        return "charge";
    }


    @PostMapping("/create-charge")
    public @ResponseBody
    Response createCharge(String studentId, String token, String price, String courseId, String userId) {
        //validate data
        if (studentId == null || price == null || courseId == null || userId == null){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATA_MISSING);
        }

        if (token == null) {
            return new Response(false, "Stripe payment token is missing. Please, try again later.");
        }
        //create charge
        Charge charge = stripeService.createCharge(userId, token, Integer.parseInt(price)*100, studentId, courseId);
        if (charge == null) {
            return new Response(false, "An error occurred while trying to create a charge.");
        }

        // You may want to store charge id along with order information

        return new Response(true, "Success! Your charge id is " + charge.getId());
    }
}
