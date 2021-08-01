package com.ms_course.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Double daylyIncome;
	private Integer days;

	public Payment() {
		
	}

	public Payment(String name, Double daylyIncome, Integer days) {
		this.name = name;
		this.daylyIncome = daylyIncome;
		this.days = days;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDaylyIncome() {
		return daylyIncome;
	}
	public void setDaylyIncome(Double daylyIncome) {
		this.daylyIncome = daylyIncome;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}

	public double getTotal(){
		return daylyIncome*days;
	}


	

}