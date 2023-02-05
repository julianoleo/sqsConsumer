package com.consumer.sqs.infrastructure.persistencia;

import com.consumer.sqs.infrastructure.persistencia.model.SqsMessages;
import com.consumer.sqs.infrastructure.persistencia.service.SqsMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistenciaImpl implements Persistencia {

    @Autowired
    private SqsMessagesService sqsMessagesService;

    @Override
    public void incluiSqsMsg(SqsMessages message) {
        sqsMessagesService.incluiMsg(message);
    }
}
