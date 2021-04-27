package com.mta.demo.schedule.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyJob {

    public boolean config = true;
    public int i = 0;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        i++;
        if(config==false){
            System.out.println(i+" Task1 - OFF " + new Date());
            return;
        }
        System.out.println(i+" Task1 - ON " + new Date());
    }

    @Scheduled(fixedRate = 10000)
    public void scheduleFixedRateTask() throws InterruptedException {
        if(config==true){
            System.out.println("Task2 - da off cau hinh " + new Date());
            config = false;
            return;
        }else {
            System.out.println("Task2 - da on cau hinh " + new Date());
            config = true;
            return;
        }
    }

//    @Scheduled(cron = "*/3 * * * * *")
//    public void scheduleTaskUsingCronExpression() throws InterruptedException {
//        System.out.println("Task3 - " + new Date());
//    }
}
