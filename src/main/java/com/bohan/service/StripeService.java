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



    public String createCharge(String studentId, String token, int amount, String userId, String courseId) {
        String id = "";
        try {
            Stripe.apiKey = API_SECRET_KEY;


            // this is like a token
            Map<String, Object> customerParams = new HashMap<>();
            customerParams.put("amount", amount);
            customerParams.put("currency", "usd");
            customerParams.put("description", "Charge for " + studentId);
            customerParams.put("customer", token); // ^ obtained with Stripe.js


            //create a charge trigger!!
            com.stripe.model.Charge charge1 = com.stripe.model.Charge.create(customerParams);

            id = charge1.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }



}
