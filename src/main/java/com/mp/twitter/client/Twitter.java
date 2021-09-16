package com.mp.twitter.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class Twitter {
    private final TwitterClientService clientService;

    @GetMapping("/soccer")
    public void getSoccerData() throws JsonProcessingException {
      ResponseEntity  entity = clientService.callLegalFootball();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(entity.getBody().toString());


        for (JsonNode node1 : root.path("events")) {
            System.out.println("Name: "+node1.get("name"));
            System.out.println("DeadTime"+node1.get("deadline_time"));

        }

        for (JsonNode node1 : root.path("game_settings")) {
            System.out.println("use special shirt"+ node1.get("ui_use_special_shirts"));

        }

        for (JsonNode node1 : root.path("phases")) {
            System.out.println("Month: "+node1.get("name"));
            System.out.println("Start event:"+node1.get("start_event"));
            System.out.println("stop_event: "+node1.get("stop_event"));

        }

        for (JsonNode node1 : root.path("teams")) {
            System.out.println("Club name: "+node1.get("name"));


        }

        System.out.println("****");





    }
}
