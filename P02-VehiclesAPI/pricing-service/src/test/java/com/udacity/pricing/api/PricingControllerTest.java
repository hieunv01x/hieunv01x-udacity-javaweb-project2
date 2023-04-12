package com.udacity.pricing.api;

import com.udacity.pricing.PricingServiceApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@ContextConfiguration(classes = PricingServiceApplicationTests.class)
public class PricingControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void getPrice() throws Exception {

        ResponseEntity<?> response =
                this.testRestTemplate.exchange
                        ("http://localhost:8082/services/price?vehicleId=1", HttpMethod.GET, new HttpEntity<>(""), String.class);
        response.hasBody();
    }
}
