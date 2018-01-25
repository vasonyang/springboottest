package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务
public class ApplicationLogTest {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationLogTest.class, args);
  }
}
