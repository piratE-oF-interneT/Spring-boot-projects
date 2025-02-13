package com.uber.services;

import com.uber.dtos.WalletTransactionDto;
import com.uber.entities.WalletTransaction;

public interface WalletTransactionService {

    WalletTransaction createNewWalletTransaction(WalletTransaction walletTransactionD);
}
