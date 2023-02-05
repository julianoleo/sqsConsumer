package com.consumer.sqs.infrastructure.util;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

@Component
public class ConvertData {

    public String timeStampToDate(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return format.format(date);
    }
}
