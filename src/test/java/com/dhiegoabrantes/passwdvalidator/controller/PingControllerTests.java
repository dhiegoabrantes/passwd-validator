package com.dhiegoabrantes.passwdvalidator.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ping() throws Exception {
        final String PONG = "\"pong\"";

        MvcResult result = mockMvc.perform(get("/ping")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals(PONG, result.getResponse().getContentAsString());
    }

}
