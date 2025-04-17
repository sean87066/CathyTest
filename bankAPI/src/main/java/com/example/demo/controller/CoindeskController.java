package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CoindeskResponse;
import com.example.demo.dto.TransformedData;
import com.example.demo.service.CoindeskService;
import com.example.demo.service.CurrencyService;

@RestController
public class CoindeskController {
	
	@Autowired
	private CoindeskService coindeskService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/coindesk/raw")
	public CoindeskResponse getRaw() {
		return coindeskService.getCoindeskData();
	}
	
	@GetMapping("/coindesk/converted")
	public TransformedData getConverted() {
		
		return coindeskService.transformData(coindeskService.getCoindeskData(), currencyService.findAll());
	}

}
