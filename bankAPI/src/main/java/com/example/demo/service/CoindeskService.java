package com.example.demo.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Currency;
import com.example.demo.dto.CoindeskResponse;
import com.example.demo.dto.CurrencyData;
import com.example.demo.dto.TransformedData;

@Service
public class CoindeskService {
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public CoindeskResponse getCoindeskData() {
		String url = "https://kengp3.github.io/blog/coindesk.json";
        return restTemplate.getForObject(url, CoindeskResponse.class);
	}
	
	public TransformedData transformData(CoindeskResponse response,List<Currency> currencyList) {
		TransformedData result = new TransformedData();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		result.setUpdateTime(ZonedDateTime.parse(response.getTime().getUpdatedISO()).format(formatter));
		
		Map<String, String> map = currencyList.stream().collect(Collectors.toMap(Currency::getCode,Currency::getChinese));
	
	
	List<CurrencyData> list = new ArrayList<>();
	response.getDetail().forEach((code, data) -> {
        CurrencyData cd = new CurrencyData();
        cd.setCode(code);
        cd.setChinese(map.getOrDefault(code, "查無中文名稱"));
        cd.setRate(data.getRate());
        list.add(cd);
    });
	
	result.setCurrencyData(list);
	return result;
	}

}
