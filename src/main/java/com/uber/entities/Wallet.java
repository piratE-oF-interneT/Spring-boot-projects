package com.uber.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long walletId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private Double balance;
	
	@OneToMany(mappedBy = "wallet")
	private List<WalletTransaction> transactions;

}
