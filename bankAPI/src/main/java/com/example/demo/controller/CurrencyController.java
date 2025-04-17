package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Currency;
import com.example.demo.service.CurrencyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/currency")
public class CurrencyController {
	
	@Autowired
	private CurrencyService service;
	
	@GetMapping
	public List<Currency> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{code}")
	public Currency get(@PathVariable String code) {
		return service.findById(code);
	}
	
	@PostMapping
	public Currency create(@RequestBody Currency c) {
		return service.save(c);
	}
	
	@PutMapping("/{code}")
	public Currency update(@PathVariable String code, @RequestBody Currency c) {
		c.setCode(code);
		return service.save(c);
	}
	
	@DeleteMapping("/{code}")
	public void delete(@PathVariable String code) {
		service.delete(code);
	}
	
	

}
