package com.test.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTest {

  private Logger logger = LoggerFactory.getLogger(ScheduleTest.class);
  
  private int fixedDelayCount = 1;
  private int fixedRateCount = 1;
  private int initialDelayCount = 1;
  private int cronCount = 1;
  
  @Scheduled(fixedDelay = 5000) // fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
  public void testFixedDelay () {
    logger.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
  }
  
  @Scheduled(fixedRate = 5000) // fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
  public void testFixedRate() {
    logger.info("===fixedRate: 第{}次执行方法", fixedRateCount++);
  }
  
  @Scheduled(initialDelay = 1000, fixedRate = 5000)   //initialDelay = 1000表示延迟1000ms执行第一次任务
  public void testInitialDelay() {
      logger.info("===initialDelay: 第{}次执行方法", initialDelayCount++);
  }

   // "0 0 * * * *"                      表示每小时0分0秒执行一次
   // " */10 * * * * *"                 表示每10秒执行一次
   // "0 0 8-10 * * *"                 表示每天8，9，10点执行
   // "0 0/30 8-10 * * *"            表示每天8点到10点，每半小时执行
   // "0 0 9-17 * * MON-FRI"     表示每周一至周五，9点到17点的0分0秒执行
   // "0 0 0 25 12 ?"                  表示每年圣诞节（12月25日）0时0分0秒执行
  @Scheduled(cron = "0 0/1 * * * ?")  //cron接受cron表达式，根据cron表达式确定定时规则
  public void testCron() {
      logger.info("===testCron: 第{}次执行方法", cronCount++);
  }
}
