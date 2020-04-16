package com.praneeth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praneeth.entity.Payment;
import com.praneeth.repository.PaymentRepository;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }


    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) {
       return repository.findByOrderId(orderId);
    }
}
