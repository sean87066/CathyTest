package com.example.demo.dto;

public class CurrencyData {
	
	private String code;
	private String chinese;
	private String rate;
	
	public CurrencyData(String code, String chinese, String rate) {
		this.code = code;
		this.chinese = chinese;
		this.rate = rate;
	}

	public CurrencyData() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
	

}
