package com.consumer.sqs.infrastructure.persistencia.service;

import com.consumer.sqs.infrastructure.persistencia.model.SqsMessages;
import com.consumer.sqs.infrastructure.persistencia.repository.SqsMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqsMessagesServiceImpl implements SqsMessagesService {

    @Autowired
    private SqsMessagesRepository sqsMessagesRepository;

    @Override
    public void incluiMsg(SqsMessages message) {
        sqsMessagesRepository.save(message);
    }
}
