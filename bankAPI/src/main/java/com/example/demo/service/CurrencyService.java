package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Currency;
import com.example.demo.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Autowired
	private CurrencyRepository repository;
	
	public List<Currency> findAll(){
		return repository.findAll();
	}
	public Currency findById(String code) {
		return repository.findById(code).orElse(null);
	}
	public Currency save(Currency currency) {
		return repository.save(currency);
	}
	public void delete(String code) {
		repository.deleteById(code);
	}

}


