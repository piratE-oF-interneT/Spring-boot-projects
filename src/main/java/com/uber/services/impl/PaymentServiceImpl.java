package com.uber.services.impl;

import com.uber.entities.Driver;
import com.uber.entities.Payment;
import com.uber.entities.Ride;
import com.uber.entities.Rider;
import com.uber.enums.PaymentStatus;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.PaymentRepository;
import com.uber.services.PaymentService;
import com.uber.stratigies.PaymentStrategyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentStrategyManager paymentStrategyManager;


    @Override
    public void processPayment(Ride ride) {

        Rider rider = ride.getRider();
        Driver driver = ride.getDriver();

        Payment payment = paymentRepository.findByRide(ride).orElseThrow(()-> new ResourceNotFoundException("payment not found for this ride id"));


        paymentStrategyManager.getPaymentStrategy(payment.getPaymentMethod()).processPayment(payment);



    }

    @Override
    public Payment createNewPayment(Ride ride) {

        Payment payment = new Payment();
        payment.setAmount(ride.getFair());
        payment.setRide(ride);
        updatePaymentStatus(payment , PaymentStatus.PENDING);
        payment.setPaymentMethod(ride.getPayment());

        return paymentRepository.save(payment);
    }

    @Override
    public void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus) {

        payment.setPaymentStatus(paymentStatus);
        paymentRepository.save(payment);
    }
}
