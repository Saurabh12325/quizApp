//package com.CloudQuest.quizApp.Service;
//
//import com.CloudQuest.quizApp.DTO.QuizMlRequest;
//import com.CloudQuest.quizApp.DTO.QuizSummaryResponse;
//import org.springframework.beans.factory.annotation.Value;
//import com.CloudQuest.quizApp.DTO.UserDTO;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Getter
//@Setter
//public class QuizSummaryService {
//
//    @Value("${ml.api.url}") // Fetches the URL from application.yml
//    private String mlApiUrl;
//
//    private final RestTemplate restTemplate;
//
//    private static final Logger logger = LoggerFactory.getLogger(QuizSummaryService.class);
//
//    public QuizSummaryService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//
//    /**
//     * Calls the ML API with the given quiz request.
//     *
//     * @param quizMlRequest the input quiz request data
//     * @return the summary response from the ML API
//     */
//    public QuizSummaryResponse getQuizSummary(QuizMlRequest quizMlRequest) {
//        try {
//            // Call the ML API using RestTemplate
//            logger.info("Sending request to ML API at URL: {}", mlApiUrl);
//            ResponseEntity<QuizSummaryResponse> response = restTemplate.postForEntity(mlApiUrl, quizMlRequest, QuizSummaryResponse.class);
//
//            // Check if response is not null
//            if (response.getBody() != null) {
//                logger.info("Successfully received response from ML API.");
//                return response.getBody();
//            } else {
//                logger.error("ML API response is empty.");
//                throw new RuntimeException("ML API returned an empty response.");
//            }
//        } catch (RestClientException e) {
//            // Log the exception and throw a custom runtime exception
//            logger.error("Error occurred while calling ML API at {}: {}", mlApiUrl, e.getMessage(), e);
//            throw new RuntimeException("Failed to call ML API. Please check the logs for more details.",e);
//        }
//
//    public QuizSummaryResponse getQuizSummary(List< QuizMlRequest.UserData > userData, QuizMlRequest.Avarages averages) {
//
//        List<UserDTO> userDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());
//
//        QuizSummaryRequest request = new QuizSummaryRequest();
//        request.setUserData(userDTOs);
//        request.setAverage(average);
//
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "application/json");
//
//        HttpEntity<QuizSummaryRequest> requestEntity = new HttpEntity<>(request, headers);
//        ResponseEntity<QuizSummaryResponse> response = restTemplate.exchange(
//                ML_API_URL,
//                HttpMethod.POST,
//                requestEntity,
//                QuizSummaryResponse.class
//        );
//
//        return response.getBody();
//
//    }
//}
