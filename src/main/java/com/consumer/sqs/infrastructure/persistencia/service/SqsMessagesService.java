package com.consumer.sqs.infrastructure.persistencia.service;

import com.consumer.sqs.infrastructure.persistencia.model.SqsMessages;

public interface SqsMessagesService {
    void incluiMsg(SqsMessages message);
}
