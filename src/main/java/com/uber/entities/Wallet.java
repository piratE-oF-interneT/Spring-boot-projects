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
	
	private Double balance = 0.0;
	
	@OneToMany(mappedBy = "wallet")
	private List<WalletTransaction> transactions;

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<WalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<WalletTransaction> transactions) {
		this.transactions = transactions;
	}

	public Wallet(Long walletId, User user, Double balance, List<WalletTransaction> transactions) {
		this.walletId = walletId;
		this.user = user;
		this.balance = balance;
		this.transactions = transactions;
	}

	public Wallet() {
	}
}
