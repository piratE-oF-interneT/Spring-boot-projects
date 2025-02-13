package com.uber.stratigies;

import com.uber.entities.Payment;

public interface PaymentStrategy {

    double PLATFORM_COMMISSION_FACTOR = 0.3;

    void processPayment(Payment payment);
}
