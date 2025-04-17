package com.example.demo.dto;

import java.util.List;

public class TransformedData {
	
	private String updateTime;
	private List<CurrencyData> currencyData;
	
	public TransformedData(String updateTime, List<CurrencyData> currencyData) {
		this.updateTime = updateTime;
		this.currencyData = currencyData;
	}

	public TransformedData() {
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<CurrencyData> getCurrencyData() {
		return currencyData;
	}

	public void setCurrencyData(List<CurrencyData> currencyData) {
		this.currencyData = currencyData;
	}
	
	
	

}
