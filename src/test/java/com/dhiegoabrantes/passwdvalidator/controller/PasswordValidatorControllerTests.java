package com.dhiegoabrantes.passwdvalidator.controller;

import com.dhiegoabrantes.passwdvalidator.dto.PasswordValidationRequest;
import com.dhiegoabrantes.passwdvalidator.dto.PasswordValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordValidatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void httpStatusOkTest() throws Exception {
        PasswordValidationRequest requestBody = PasswordValidationRequest.builder().word("").build();

        final MockHttpServletRequestBuilder post = post(PasswordValidatorController.PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody));

        MvcResult result = mockMvc
                .perform(post)
                .andExpect(status().isOk())
                .andReturn();

        final PasswordValidationResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), PasswordValidationResponse.class);

        assertNotNull(response);
        assertFalse(response.isValid());
    }

    @Test
    public void httpStatusBadRequestTest() throws Exception {
         mockMvc.perform(
                 post(PasswordValidatorController.PATH)
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(objectMapper.writeValueAsString(null)))
                 .andExpect(status().is4xxClientError())
                 .andReturn();
    }

}
