package com.mp.twitter.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import com.fasterxml.jackson.databind.JsonNode;

@Slf4j
@Service
@AllArgsConstructor
public class TwitterClientService {
    private final RestTemplate twitterRestTemplate;
    private final TwitterProperties properties;


    @Retryable(backoff = @Backoff(delay = 100))
    public ResponseEntity<JsonNode> callLegalFootball() {
        return twitterRestTemplate.getForEntity(properties.getUrl(),JsonNode.class);
    }
}
