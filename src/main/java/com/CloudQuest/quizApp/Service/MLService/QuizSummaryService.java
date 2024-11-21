package com.CloudQuest.quizApp.Service.MLService;
import com.CloudQuest.quizApp.DTO.Average;
import com.CloudQuest.quizApp.DTO.QuizSummaryRequest;
import com.CloudQuest.quizApp.DTO.QuizSummaryResponse;
import com.CloudQuest.quizApp.DTO.UserDTO;
import com.CloudQuest.quizApp.Entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizSummaryService {

    private final RestTemplate restTemplate;
    private static final String ML_API_URL = "https://quizz-ml.onrender.com/sum";

    public QuizSummaryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public QuizSummaryResponse getSummary(List<User> users, Average average) {
        // Convert User entities to UserDTOs
        List<UserDTO> userDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());

        // Prepare request payload
        QuizSummaryRequest request = new QuizSummaryRequest();
        request.setUserData(userDTOs);
        request.setAverage(average);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Send request
        HttpEntity<QuizSummaryRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<QuizSummaryResponse> response = restTemplate.exchange(
                ML_API_URL,
                HttpMethod.POST,
                requestEntity,
                QuizSummaryResponse.class
        );

        return response.getBody();
    }
}
