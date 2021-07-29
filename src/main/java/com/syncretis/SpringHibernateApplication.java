package com.syncretis;

import com.syncretis.repository.RunService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringHibernateApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringHibernateApplication.class, args);
        RunService runService = run.getBean("runService", RunService.class);
        runService.run();
    }
}
