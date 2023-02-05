package com.consumer.sqs.infrastructure;

import com.consumer.sqs.infrastructure.persistencia.Persistencia;
import com.consumer.sqs.infrastructure.persistencia.model.SqsMessages;
import com.consumer.sqs.infrastructure.util.ConvertData;
import com.consumer.sqs.infrastructure.util.ObjectConverter;
import io.awspring.cloud.messaging.core.SqsMessageHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

import static com.fasterxml.jackson.core.io.NumberInput.parseLong;

@Service
public class InfraImpl implements Infra{

    @Autowired
    private Persistencia persistencia;

    @Autowired
    private ObjectConverter objectConverter;

    @Autowired
    private ConvertData convertData;

    @Override
    public void incluiMessage(SqsMessageHeaders sqsMessageHeaders, String message) {
        var msg = objectConverter.stringToObject(message, SqsMessages.class);
        msg.setIdMsgSqs(UUID.fromString(sqsMessageHeaders.get("MessageId").toString()));
        //String dataMsg =  convertData.timeStampToDate(parseLong(sqsMessageHeaders.get("timestamp").toString()));
        var dataMsg = new Timestamp(parseLong(sqsMessageHeaders.get("timestamp").toString()));
        msg.setDatamsg(dataMsg);
        persistencia.incluiSqsMsg(msg);
    }
}
