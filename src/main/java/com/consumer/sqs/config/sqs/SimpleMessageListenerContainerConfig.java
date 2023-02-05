package com.consumer.sqs.config.sqs;

import io.awspring.cloud.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageListenerContainerConfig {

    private final AsyncTaskExecutor executor;


    public SimpleMessageListenerContainerConfig(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    @EventListener
    public void handleContextRefreshedEvent(ContextRefreshedEvent event) {
        final ApplicationContext applicationContext = event.getApplicationContext();
        final SimpleMessageListenerContainer simpleMessageListenerContainer = applicationContext.getBean(SimpleMessageListenerContainer.class);
        setAsyncTaskExecutor(simpleMessageListenerContainer);
    }

    private void setAsyncTaskExecutor(SimpleMessageListenerContainer simpleMessageListenerContainer) {
        try {
            simpleMessageListenerContainer.setTaskExecutor(executor);
        } catch (Exception e) {
            throw new RuntimeException("Task Executor Error.", e);
        }
    }
}
