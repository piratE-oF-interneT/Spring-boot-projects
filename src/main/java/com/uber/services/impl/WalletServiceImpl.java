package com.uber.services.impl;

import com.uber.entities.Ride;
import com.uber.entities.User;
import com.uber.entities.Wallet;
import com.uber.entities.WalletTransaction;
import com.uber.enums.WalletTransactionMethod;
import com.uber.enums.WalletTransactionType;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.UserRepository;
import com.uber.repositories.WalletRepository;
import com.uber.services.WalletService;
import com.uber.services.WalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletTransactionService walletTransactionService;


    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);



        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet AddMoneyTOWallet(User user, Double amount , String transactionId, Ride ride,WalletTransactionMethod walletTransactionMethod) {

        Wallet wallet = findWalletByUser(user);

        wallet.setBalance(wallet.getBalance()+amount);

        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setAmount(amount);
        walletTransaction.setWallet(wallet);
        walletTransaction.setTransactionId(transactionId);

        walletTransaction.setRide(ride);
        walletTransaction.setTransactionMethod(walletTransactionMethod);
        walletTransaction.setTransactionType(WalletTransactionType.CREDIT);

//        wallet.getTransactions().add(walletTransaction);
        walletTransactionService.createNewWalletTransaction(walletTransaction);







        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet deductMoney(User user, Double amount, String transactionId, Ride ride, WalletTransactionMethod walletTransactionMethod) {

        Wallet wallet = findWalletByUser(user);

        wallet.setBalance(wallet.getBalance()-amount);

        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setAmount(amount);

        walletTransaction.setWallet(wallet);
        walletTransaction.setTransactionId(transactionId);

        walletTransaction.setRide(ride);
        walletTransaction.setTransactionMethod(walletTransactionMethod);
        walletTransaction.setTransactionType(WalletTransactionType.DEBIT);

        walletTransactionService.createNewWalletTransaction(walletTransaction);






        return walletRepository.save(wallet);




    }

    @Override
    public void withdrawAllAmount(User user) {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId).orElseThrow(()-> new ResourceNotFoundException("wallet with this id is not found ..."));

    }

    @Override
    public Wallet findWalletByUser(User user) {



        return walletRepository.findByUser(user);
    }


}
