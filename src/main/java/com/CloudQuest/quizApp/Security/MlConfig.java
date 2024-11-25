package com.CloudQuest.quizApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MlConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
}
}
