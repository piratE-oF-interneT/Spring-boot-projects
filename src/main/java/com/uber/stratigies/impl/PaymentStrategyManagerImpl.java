package com.uber.stratigies.impl;

import com.uber.enums.PaymentMethod;
import com.uber.stratigies.PaymentStrategy;
import com.uber.stratigies.PaymentStrategyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyManagerImpl implements PaymentStrategyManager {

    @Autowired
    private WalletPaymentProcessStartegyImpl walletPaymentProcessStartegy;

    @Autowired
    private CODPaymentProcessStrategyImpl codPaymentProcessStrategy;

    @Override
    public PaymentStrategy getPaymentStrategy(PaymentMethod paymentMethod) {


        return switch (paymentMethod){
            case PaymentMethod.CASH -> codPaymentProcessStrategy;
            case PaymentMethod.WALLET -> walletPaymentProcessStartegy;
            default -> throw new RuntimeException("invalid payment method");
        };
    }
}
