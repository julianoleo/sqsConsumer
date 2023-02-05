package com.consumer.sqs.infrastructure.persistencia;

import com.consumer.sqs.infrastructure.persistencia.model.SqsMessages;

public interface Persistencia {
    void incluiSqsMsg(SqsMessages message);
}
