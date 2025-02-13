package com.uber.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import com.uber.enums.WalletTransactionMethod;
import com.uber.enums.WalletTransactionType;

@Entity
@Table(
		indexes = {
				@Index(name = "idx_wallettransaction_wallet" , columnList = "wallet_id"),
				@Index(name = "idx_wallettransaction_ride" , columnList = "ride_id")
		}
)
public class WalletTransaction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long walletTransactionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wallet_id")
	private Wallet wallet;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private WalletTransactionType transactionType;
	
	@ManyToOne
	@JoinColumn(name = "ride_id")
	private Ride ride;
	
	private String transactionId;
	
	@CreationTimestamp
	private LocalDateTime timestamp;
	
	@Enumerated(EnumType.STRING)
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

	public WalletTransaction(Long walletTransactionId, Wallet wallet, Double amount, WalletTransactionType transactionType, Ride ride, String transactionId, LocalDateTime timestamp, WalletTransactionMethod transactionMethod) {
		this.walletTransactionId = walletTransactionId;
		this.wallet = wallet;
		this.amount = amount;
		this.transactionType = transactionType;
		this.ride = ride;
		this.transactionId = transactionId;
		this.timestamp = timestamp;
		this.transactionMethod = transactionMethod;
	}

	public WalletTransaction(){

	}
}
