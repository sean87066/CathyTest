package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
	
	@Id
	@Column(name= "code", nullable= false, unique = true)
	private String code;
	
	@Column(name = "chinese", nullable = false)
	private String chinese;
	
	public Currency() {
		
	}
	
	public Currency(String code, String chinese) {
		this.code = code;
		this.chinese = chinese;
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
	
	

}
