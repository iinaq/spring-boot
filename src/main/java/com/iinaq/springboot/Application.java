package com.iinaq.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.apache.catalina.core.ApplicationContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@RestController
@SpringBootApplication(scanBasePackages = "com.iinaq.springboot")
@EnableAutoConfiguration
@EnableAdminServer
@EnableAsync
@MapperScan("com.iianq.springboot.mapper")
@EnableWebSocket
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/demo1")
    public String demo1(){
        return "hello battch";
    }

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler schedulerPool = new ThreadPoolTaskScheduler();
        schedulerPool.setPoolSize(10);
        return schedulerPool;
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
