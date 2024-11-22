package com.CloudQuest.quizApp.Service.MLService;

import com.CloudQuest.quizApp.DTO.QuizMlRequest;
import com.CloudQuest.quizApp.DTO.QuizSummaryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class QuizSummaryService {

    @Value("${ml.api.url}") // Fetches the URL from application.yml
    private String mlApiUrl;

    private final RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(QuizSummaryService.class);

    public QuizSummaryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Calls the ML API with the given quiz request.
     *
     * @param quizMlRequest the input quiz request data
     * @return the summary response from the ML API
     */
    public QuizSummaryResponse getQuizSummary(QuizMlRequest quizMlRequest) {
        try {
            // Call the ML API using RestTemplate
            logger.info("Sending request to ML API at URL: {}", mlApiUrl);
            ResponseEntity<QuizSummaryResponse> response = restTemplate.postForEntity(mlApiUrl, quizMlRequest, QuizSummaryResponse.class);

            // Check if response is not null
            if (response.getBody() != null) {
                logger.info("Successfully received response from ML API.");
                return response.getBody();
            } else {
                logger.error("ML API response is empty.");
                throw new RuntimeException("ML API returned an empty response.");
            }
        } catch (RestClientException e) {
            // Log the exception and throw a custom runtime exception
            logger.error("Error occurred while calling ML API at {}: {}", mlApiUrl, e.getMessage(), e);
            throw new RuntimeException("Failed to call ML API. Please check the logs for more details.",e);
        }
    }
}
