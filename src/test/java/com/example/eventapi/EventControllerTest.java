package com.example.eventapi;


import org.example.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateEvent() throws Exception {
        Event event = new Event("Tech Meetup", "Bangalore", LocalDate.now(), "Spring Boot Event");

        mockMvc.perform(post("/api/events")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(event)))
                .andExpect(status().isCreated());
    }
}

