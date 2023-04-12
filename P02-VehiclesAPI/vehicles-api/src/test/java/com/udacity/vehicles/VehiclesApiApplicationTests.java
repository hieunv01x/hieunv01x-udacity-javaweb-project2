package com.udacity.vehicles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiclesApiApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Configuration
    class RestTemplateConfig {

        /*
        * Create a bean
        * Load balance between multiple TCP ports on the same server
        * */
        @Bean
        @LoadBalanced
        public TestRestTemplate testRestTemplate() {
            return new TestRestTemplate();
        }
    }
}
