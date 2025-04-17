package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CoindeskResponse;
import com.example.demo.service.CoindeskService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CoindeskApiTest {

    @Autowired
    private CoindeskService coindeskService;

    @Test
    public void testCoindeskApiCall() {
        CoindeskResponse res = coindeskService.getCoindeskData();

        assertNotNull(res);
        assertNotNull(res.getTime());
        assertNotNull(res.getTime().getUpdatedISO());
        assertNotNull(res.getDetail());
        assertTrue(res.getDetail().containsKey("USD"));
    }
}
