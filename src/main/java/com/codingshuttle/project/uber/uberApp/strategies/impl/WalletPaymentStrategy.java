package com.codingshuttle.project.uber.uberApp.strategies.impl;

import com.codingshuttle.project.uber.uberApp.entities.Driver;
import com.codingshuttle.project.uber.uberApp.entities.Payment;
import com.codingshuttle.project.uber.uberApp.entities.Rider;
import com.codingshuttle.project.uber.uberApp.entities.Wallet;
import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentStatus;
import com.codingshuttle.project.uber.uberApp.entities.enums.TransactionMethod;
import com.codingshuttle.project.uber.uberApp.services.PaymentService;
import com.codingshuttle.project.uber.uberApp.services.WalletService;
import com.codingshuttle.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentService paymentService;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Rider rider = payment.getRide().getRider();
        Driver driver = payment.getRide().getDriver();

        //Deduct money from riders wallet
        walletService.deductMoneyFromWallet(
                rider.getUser(),
                payment.getAmount(),
                null,
                payment.getRide(),
                TransactionMethod.RIDE
        );

        Double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        //Add money to drivers wallet
        walletService.addMoneyToWallet(
                driver.getUser(),
                driversCut,
                null,
                payment.getRide(),
                TransactionMethod.RIDE
        );

        paymentService.updatePaymentStatus(payment, PaymentStatus.CONFIRMED);
    }
}
