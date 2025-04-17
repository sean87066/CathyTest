package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Currency;
import com.example.demo.dto.CoindeskResponse;
import com.example.demo.dto.TransformedData;
import com.example.demo.service.CoindeskService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoindeskTransformUnitTest {

    @Autowired
    private CoindeskService coindeskService;

    @Test  // 模擬 CoindeskResponse 時間與匯率資料
    public void testTransformData_success() {
        
        CoindeskResponse response = new CoindeskResponse();
        CoindeskResponse.Time time = new CoindeskResponse.Time();
        time.setUpdatedISO("2024-09-02T07:07:20+00:00");
        response.setTime(time);

        CoindeskResponse.Detail usdDetail = new CoindeskResponse.Detail();
        usdDetail.setRate("57756.2984");
        Map<String, CoindeskResponse.Detail> detailMap = new HashMap<>();
        detailMap.put("USD", usdDetail);
        response.setDetail(detailMap);

        List<Currency> currencyList = List.of(new Currency("USD", "美元"));

        TransformedData result = coindeskService.transformData(response, currencyList);

        assertEquals("2024/09/02 07:07:20", result.getUpdateTime());
        assertEquals(1, result.getCurrencyData().size());
        assertEquals("USD", result.getCurrencyData().get(0).getCode());
        assertEquals("美元", result.getCurrencyData().get(0).getChinese());
        assertEquals("57756.2984", result.getCurrencyData().get(0).getRate());
    }
}