package com.ms_course.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import com.ms_course.hrpayroll.entities.Payment;
import com.ms_course.hrpayroll.entities.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

	@Value("${hrworker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days){

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);

		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
