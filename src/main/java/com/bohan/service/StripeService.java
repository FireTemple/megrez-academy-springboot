package com.bohan.service;

import com.bohan.entity.Charge;
import com.bohan.service.impl.ChargeServiceImpl;
import com.stripe.Stripe;
import com.stripe.model.Coupon;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StripeService {

    @Value("${stripe.keys.secret}")
    private String API_SECRET_KEY;

    @Autowired
    CourseStudentService courseStudentService;

    @Autowired
    ChargeServiceImpl chargeService;


    public StripeService(){

    }

    public String createCustomer(String email, String token){
        String id = null;

        try{

            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> customerParams = new HashMap<>();

            customerParams.put("description", "Customer for" + email);
            customerParams.put("email", email);

            customerParams.put("source", token);

            Customer customer = Customer.create(customerParams);

            id = customer.getId();


        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public String createSubscription(String customerId, String plan, String coupon){
        String id = null;

        try{
            Stripe.apiKey = API_SECRET_KEY;
            Map<Object, Object> item = new HashMap<>();
            item.put("plan", plan);

            Map<String , Object> items = new HashMap<>();
            items.put("0", item);

            Map<String, Object> params = new HashMap<>();
            params.put("customer", customerId);
            params.put("items", items);

            //add coupon if available
            if (!coupon.isEmpty()) {
                params.put("coupon", coupon);
            }

            Subscription sub = Subscription.create(params);
            id = sub.getId();

        } catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public boolean cancelSubscription(String subscriptionId) {
        boolean status;
        try {
            Stripe.apiKey = API_SECRET_KEY;
            Subscription sub = Subscription.retrieve(subscriptionId);
            sub.cancel(null);
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        }
        return status;
    }

    public Coupon retrieveCoupon(String code) {
        try {
            Stripe.apiKey = API_SECRET_KEY;
            return Coupon.retrieve(code);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Transactional
    public Charge createCharge(String studentId, String token, int amount, String userId, String courseId) {
        Charge charge = new Charge();
        try {
            Stripe.apiKey = API_SECRET_KEY;
            // this is like a token
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", amount);
            chargeParams.put("currency", "usd");
            chargeParams.put("description", "Charge for " + studentId);
            chargeParams.put("source", token); // ^ obtained with Stripe.js

            // 1. register a course
            courseStudentService.registerCourse(studentId, courseId);

            // 2. create a Charge object

            charge.setId(UUID.randomUUID().toString());
            charge.setAmount(String.valueOf(amount));
            charge.setcId(courseId);
            charge.setsId(studentId);
            charge.setCreateTime(new Date().toString());
            charge.setpId(userId);
            charge.setToken(token);
            charge.setStatus("1");

            // 4. payment record
            chargeService.addNewCharge(charge);
            return charge;
//            chargeService.addNewCharge();

            //create a charge trigger!!
//            Charge charge = Charge.create(chargeParams);
//            id = charge.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return charge;
    }

//    @Transactional
//    public String triggerCharge(String courseId){
//        List<String> chargeIds = chargeService.queryByCourseId(courseId);
//    }

}
