package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CoindeskConvertedApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConvertedApi() throws Exception {
        mockMvc.perform(get("/coindesk/converted"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.updateTime").exists())
                .andExpect(jsonPath("$.currencyData").isArray())
                .andExpect(jsonPath("$.currencyData[0].code").exists())
                .andExpect(jsonPath("$.currencyData[0].rate").exists());
    }
}