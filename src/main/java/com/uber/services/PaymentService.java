package com.uber.services;

import com.uber.entities.Payment;
import com.uber.entities.Ride;
import com.uber.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment , PaymentStatus paymentStatus);
}
