package com.uber.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.uber.enums.WalletTransactionMethod;
import com.uber.enums.WalletTransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
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
	
	@OneToOne
	@JoinColumn(name = "ride_id")
	private Ride ride;
	
	private String transactionId;
	
	@CreationTimestamp
	private LocalDateTime timestamp;
	
	@Enumerated(EnumType.STRING)
	private WalletTransactionMethod transactionMethod;
	
	
	

}
