package com.consumer.sqs.infrastructure;

import io.awspring.cloud.messaging.core.SqsMessageHeaders;

public interface Infra {
    void incluiMessage(SqsMessageHeaders sqsMessageHeaders, String message);
}
