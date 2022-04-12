package com.codingdojo.ninjaGold.models;

import java.util.Date;

public class Action {
	private String negPos;
	private Integer amount;
	private String type;
	private Date date;
	
	public Action(String negPos, Integer amount, String type) {
		super();
		this.negPos = negPos;
		this.amount = amount;
		this.type = type;
		this.date = new Date();
		
	}

	public String getNegPos() {
		return negPos;
	}

	public void setNegPos(String negPos) {
		this.negPos = negPos;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
