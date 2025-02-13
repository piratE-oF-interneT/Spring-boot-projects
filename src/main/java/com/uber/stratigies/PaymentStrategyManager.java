package com.uber.stratigies;

import com.uber.enums.PaymentMethod;

public interface PaymentStrategyManager {

    PaymentStrategy getPaymentStrategy(PaymentMethod paymentMethod);
}
