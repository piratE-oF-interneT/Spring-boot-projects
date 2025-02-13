package com.uber.stratigies.impl;

import com.uber.entities.Driver;
import com.uber.entities.Payment;
import com.uber.entities.Wallet;
import com.uber.enums.PaymentStatus;
import com.uber.enums.WalletTransactionMethod;
import com.uber.repositories.PaymentRepository;
import com.uber.services.PaymentService;
import com.uber.services.WalletService;
import com.uber.services.impl.WalletServiceImpl;
import com.uber.stratigies.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CODPaymentProcessStrategyImpl implements PaymentStrategy {

    @Autowired
    private WalletService walletService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();

        double platformCommission = PLATFORM_COMMISSION_FACTOR*payment.getAmount();
        walletService.deductMoney(driver.getUser() , platformCommission , null,payment.getRide(), WalletTransactionMethod.RIDE);

//        paymentService.updatePaymentStatus(payment,PaymentStatus.COMPLETED); --> results cyclic dependency

        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        paymentRepository.save(payment);
    }
}
