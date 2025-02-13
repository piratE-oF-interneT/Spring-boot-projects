package com.uber.dtos;

import com.uber.entities.Ride;
import com.uber.entities.Wallet;
import com.uber.enums.WalletTransactionMethod;
import com.uber.enums.WalletTransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class WalletTransactionDto {


    private Long walletTransactionId;


    private Wallet wallet;

    private Double amount;


    private WalletTransactionType transactionType;


    private Ride ride;

    private String transactionId;


    private LocalDateTime timestamp;

    private WalletTransactionMethod transactionMethod;

    public Long getWalletTransactionId() {
        return walletTransactionId;
    }

    public void setWalletTransactionId(Long walletTransactionId) {
        this.walletTransactionId = walletTransactionId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public WalletTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(WalletTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public WalletTransactionMethod getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(WalletTransactionMethod transactionMethod) {
        this.transactionMethod = transactionMethod;
    }
}
