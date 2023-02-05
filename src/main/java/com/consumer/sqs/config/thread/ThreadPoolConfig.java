package com.consumer.sqs.config.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Value("${threads.active}")
    private String threads;

    @Value("${threads.max}")
    private String maxThreads;

    @Value("${threads.queue}")
    private String queue;

    @Bean
    @Primary
    public AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(Integer.parseInt(threads));
            executor.setMaxPoolSize(Integer.parseInt(maxThreads));
            executor.setQueueCapacity(Integer.parseInt(queue));
            executor.setThreadNamePrefix("ThreadEx--");
            executor.initialize();
            return executor;
    }
}
