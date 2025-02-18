package com.getoze.task.management.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getoze.task.management.domain.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractWebTest {

    private static final String STANDARD_MESSAGE = "Processed Well";

    @Autowired
    protected MockMvc mockMvc;

    protected String objectToJsonString(Object object){
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            return mapper.writeValueAsString(object);
        }catch (Exception e) {
            String errorMessage = String.format("Unable to convert class [%s] to json String. Caught a %s. %s", object.getClass().getCanonicalName(), e.getClass().getCanonicalName(), e.getMessage());
            throw new RuntimeException(errorMessage, e);
        }
    }

    protected Response<String> getResponse(String message){
        return new Response<>(Boolean.TRUE,message,STANDARD_MESSAGE);
    }
}
