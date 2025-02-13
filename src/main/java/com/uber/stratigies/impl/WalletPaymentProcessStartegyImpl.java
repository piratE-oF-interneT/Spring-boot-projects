package com.uber.stratigies.impl;

import com.uber.entities.Driver;
import com.uber.entities.Payment;
import com.uber.entities.Rider;
import com.uber.enums.PaymentStatus;
import com.uber.enums.WalletTransactionMethod;
import com.uber.repositories.PaymentRepository;
import com.uber.services.PaymentService;
import com.uber.services.WalletService;
import com.uber.stratigies.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletPaymentProcessStartegyImpl implements PaymentStrategy {

    @Autowired
    private WalletService walletService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Rider rider = payment.getRide().getRider();
        Driver driver = payment.getRide().getDriver();

        double driverCut = payment.getAmount()* (1-PLATFORM_COMMISSION_FACTOR);


//        deduct amount from rider

        walletService.deductMoney(rider.getUser() , payment.getAmount() , null , payment.getRide() , WalletTransactionMethod.RIDE);
        walletService.AddMoneyTOWallet(driver.getUser() , driverCut , null , payment.getRide() , WalletTransactionMethod.RIDE);

//        paymentService.updatePaymentStatus(payment , PaymentStatus.COMPLETED); --> results cyclic dependency.

        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        paymentRepository.save(payment);



    }
}
