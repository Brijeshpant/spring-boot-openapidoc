package com.brij.examples.resource;

import com.brij.examples.resource.domain.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserResource.class)
public class UserResourceTest {
    @Autowired
    MockMvc mvc;

    @Test
    void shouldRespondWithErrorWhenMandatoryFieldsAreMissing() throws Exception {

        ApiError expected = new ApiError();
        expected.setMessage("Invalid request");
        expected.setInvalidFields(Arrays.asList("firstName", "lastName", "email"));
        //arrange : input, mock
        //act : take the action
        //assert match the result with the

        MvcResult mvcResult = mvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isBadRequest()).andReturn();
        assertEquals(new ObjectMapper().writeValueAsString(expected), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void shouldRespondWithErrorWhenEmailPatternIsInvalid() {

    }

    @Test
    void shouldRespondWithErrorWhenUserAlreadyExists() {

    }

    @Test
    void shouldRespondWithErrorWhenSomethingGoesWrong() {

    }

    @Test
    void shouldRespondWithSuccessRespinse() {

    }
}
