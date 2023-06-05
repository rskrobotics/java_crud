package com.example.krud.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ScheduledTaskComponent {

    private final ExecutorService executorService;

    public ScheduledTaskComponent() {
        executorService = Executors.newFixedThreadPool(5);
    }

    @Scheduled(fixedRate = 3000)
    public void scheduledTask() {
        executorService.execute(() ->
                System.out.println("Asynchronously ran in the scheduler by: " + Thread.currentThread().getName()));
    }
}
