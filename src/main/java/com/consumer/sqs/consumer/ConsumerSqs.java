package com.consumer.sqs.consumer;

import com.consumer.sqs.infrastructure.Infra;
import io.awspring.cloud.messaging.core.SqsMessageHeaders;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class ConsumerSqs {
    private static final Logger LOGGER = LogManager.getLogger(ConsumerSqs.class);

    @Autowired
    private Infra infra;

    @SqsListener(value = "${sqs.fila}")
    public void receiveMessage(
            @Headers Map<String, Object> allHeaders,
            SqsMessageHeaders sqsMessageHeaders,
            String message
    ) {
        try {
            infra.incluiMessage(sqsMessageHeaders, message);
            LOGGER.info("Mensagem " + sqsMessageHeaders.get("MessageId") + " incluída com sucesso!");
        } catch (Exception e) {
            LOGGER.error("Erro na inclusão do Payload no Database: " + e.getMessage());
        }
    }
}
