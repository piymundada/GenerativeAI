package dev.piyush.GenerativeAI.configuration;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
