package com.consumer.sqs.infrastructure.persistencia.repository;

import com.consumer.sqs.infrastructure.persistencia.model.SqsMessages;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface SqsMessagesRepository extends Repository<SqsMessages, UUID> {
    void save(SqsMessages sqsMessages);
}
