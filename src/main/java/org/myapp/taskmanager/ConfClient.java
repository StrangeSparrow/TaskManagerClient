package org.myapp.taskmanager;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.myapp.taskmanager.client.ProjectClient;
import org.myapp.taskmanager.client.TaskClient;
import org.myapp.taskmanager.client.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfClient {
    @Bean
    public TaskClient taskClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(TaskClient.class))
                .logLevel(Logger.Level.FULL)
                .target(TaskClient.class, "http://localhost:8080/tasks");
    }

    @Bean
    public UserClient userClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserClient.class))
                .logLevel(Logger.Level.FULL)
                .target(UserClient.class, "http://localhost:8080/users");
    }

    @Bean
    public ProjectClient projectClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ProjectClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ProjectClient.class, "http://localhost:8080/projects");
    }
}
