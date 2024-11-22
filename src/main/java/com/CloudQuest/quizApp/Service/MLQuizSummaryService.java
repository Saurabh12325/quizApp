package com.CloudQuest.quizApp.Service;
import com.CloudQuest.quizApp.DTO.Average;
import com.CloudQuest.quizApp.DTO.QuizSummaryRequest;
import com.CloudQuest.quizApp.DTO.QuizSummaryResponse;
import com.CloudQuest.quizApp.DTO.UserDTO;
import com.CloudQuest.quizApp.Entity.Player;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Getter
@Setter
public class MLQuizSummaryService {

    private final RestTemplate restTemplate;
    private static final String ML_API_URL = "https://quizz-ml.onrender.com/sum";

    public MLQuizSummaryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public QuizSummaryResponse getSummary(List<Player> users, Average average) {

        List<UserDTO> userDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());

        QuizSummaryRequest request = new QuizSummaryRequest();
        request.setUserData(userDTOs);
        request.setAverage(average);


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

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
