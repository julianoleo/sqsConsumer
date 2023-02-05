package com.consumer.sqs.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectConverter {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LogManager.getLogger(ObjectConverter.class);

    public <T> T stringToObject(String content, Class<T> object) {
        try {
            return objectMapper.readValue(content, object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Erro na serialização do payload: {}", content, e.getMessage());
            throw new RuntimeException("Erro na serialização do payload: " + content);
        }
    }
}
