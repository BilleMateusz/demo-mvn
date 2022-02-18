package com.example.demo.mvn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Slf4j
@RestController
public class TestController {

    private RestTemplate restTemplate = new RestTemplate();;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TimeService timeService;

    @GetMapping
    public String test() throws IOException, URISyntaxException, InterruptedException {

        URI uiUriToken = new URI("http://localhost:8080/uat/sso/oauth/token");
        URI apiUriToken = new URI("http://localhost:8080/uat/sso/me/apitoken");
        String uiAccessToken = getUiAccessToken(uiUriToken);
        String apiAccessToken = getApiAccessToken(apiUriToken, uiAccessToken);

       // URI testUri = new URI("http://localhost:8080/api/v1/project/names");
        URI testUri = new URI("http://localhost:8080/api/v1/my_test_project/launch/attribute/keys");
        ResponseEntity<String> stringResponseEntity = getStringResponseEntity(testUri, apiAccessToken);

        return stringResponseEntity.getBody();
    }

    private String getApiAccessToken(URI apiUriToken, String uiAccessToken) throws JsonProcessingException {
        ResponseEntity<String> response2 = getStringResponseEntity(apiUriToken, uiAccessToken);
        JsonNode root = objectMapper.readTree(response2.getBody());
        return root.get("access_token").textValue();
    }

    private ResponseEntity<String> getStringResponseEntity(URI uri, String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
    }

    private String getUiAccessToken(URI uiUriToken) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("ui", "uiman");
        HttpEntity<String> request = new HttpEntity<>("grant_type=password&username=superadmin&password=erebus", headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uiUriToken, request , String.class );
        JsonNode root = objectMapper.readTree(response.getBody());
        return root.get("access_token").textValue();
    }

    private ResponseEntity<String> startLaunch() {
        return null; //TODO implement
    }
}
