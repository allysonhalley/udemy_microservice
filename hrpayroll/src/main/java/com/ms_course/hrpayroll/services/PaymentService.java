package com.ms_course.hrpayroll.services;

import com.ms_course.hrpayroll.entities.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days){
		return new Payment("Dudu", 500.0, days);
	}
	
}
