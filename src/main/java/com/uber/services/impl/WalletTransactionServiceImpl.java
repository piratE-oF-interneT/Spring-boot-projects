package com.uber.services.impl;

import com.uber.dtos.WalletTransactionDto;
import com.uber.entities.WalletTransaction;
import com.uber.repositories.WalletTransactionRepository;
import com.uber.services.WalletTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService {


    @Autowired
    private WalletTransactionRepository walletTransactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public WalletTransaction createNewWalletTransaction(WalletTransaction walletTransaction) {

//        WalletTransaction walletTransaction = modelMapper.map(walletTransactionDto , WalletTransaction.class);

        walletTransactionRepository.save(walletTransaction);

        return walletTransaction;
    }
}
