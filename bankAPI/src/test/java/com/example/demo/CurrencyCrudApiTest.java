package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyCrudApiTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test // 建立一個新幣別
	public void testCreateCurrency() throws Exception{
		
		String json = "{\"code\":\"JPY\",\"chinese\":\"日圓\"}";
		
		mockMvc.perform(post("/currency")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$.code").value("JPY"));
	}
	
	@Test // 查詢該幣別
	public void testSearchCurrency() throws Exception{
		mockMvc.perform(get("/currency/JPY"))
	    .andExpect(status().isOk())
	    .andExpect(jsonPath("$.chinese").value("日圓"));
	}
	
	@Test // 修改幣別
	public void testUpdateCurrenct() throws Exception{
		String json = "{\"code\":\"JPY\",\"chinese\":\"日幣\"}";
		
		mockMvc.perform(put("/currency/JPY")
				.contentType(MediaType.APPLICATION_JSON)
                .content(json))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.chinese").value("日幣"));
	}
	
	@Test //刪除幣別
	public void testDeleteCurrency() throws Exception {
        mockMvc.perform(delete("/currency/JPY"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/currency/JPY"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
	
	

}
