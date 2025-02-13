package com.uber.entities;

import java.time.LocalDateTime;

import com.uber.enums.PaymentMethod;
import org.hibernate.annotations.CreationTimestamp;

import com.uber.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	@OneToOne
	@JoinColumn(name="ride_id")
	private Ride ride;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private Double amount;
	
	@CreationTimestamp
	private LocalDateTime paymnetTime;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymnetTime() {
		return paymnetTime;
	}

	public void setPaymnetTime(LocalDateTime paymnetTime) {
		this.paymnetTime = paymnetTime;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Payment(Long paymentId, Ride ride, PaymentStatus paymentStatus, Double amount, LocalDateTime paymnetTime , PaymentMethod paymentMethod) {
		this.paymentId = paymentId;
		this.ride = ride;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
		this.paymnetTime = paymnetTime;
		this.paymentMethod = paymentMethod;
	}

	public Payment(){

	}
}
