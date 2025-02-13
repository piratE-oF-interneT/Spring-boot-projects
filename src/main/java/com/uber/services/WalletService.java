package com.uber.services;


import com.uber.entities.Ride;
import com.uber.entities.User;
import com.uber.entities.Wallet;
import com.uber.enums.WalletTransactionMethod;

public interface WalletService {

    Wallet createNewWallet(User user);

    Wallet AddMoneyTOWallet(User user, Double amount , String transactionId, Ride ride, WalletTransactionMethod walletTransactionMethod);

    void withdrawAllAmount(User user);

    Wallet findWalletById(Long walletId);

    Wallet findWalletByUser(User user);

    Wallet deductMoney(User user, Double amount , String transactionId, Ride ride, WalletTransactionMethod walletTransactionMethod);






}
