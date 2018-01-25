package com.test.schedule;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicTask {

  @Autowired
  private ThreadPoolTaskScheduler threadPoolTaskScheduler;
  
  private ScheduledFuture<?> future;
  
  @Bean
  public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
    return new ThreadPoolTaskScheduler();
  }
  
  @RequestMapping(value="/startCron")
  public String startCron() {
    future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/5 * * * * *"));
    System.out.println("DynamicTask.startCron()");
    return "startCron";
  }
  
  @RequestMapping(value="/stopCron")
  public String stopCron() {
     if (future != null) {
       future.cancel(true);
     }
     System.out.println("DynamicTask.stopCron()");
     return "stopCron";
  }
  
  @RequestMapping("/changeCron10")
  public String changeCron10() {
     stopCron();// 先停止，在开启.
     future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/10 * * * * *"));
     System.out.println("DynamicTask.changeCron10()");
     return "changeCron10";
  }
  
  
  private String cronStr = "*/5 * * * * *";
  /**
   * 第二种启动的写法，这里是自定义Trigger
   * @return
   */
  @RequestMapping("/startCron1")
  public String startCron1(){

      System.out.println("startCron1 >>>>");
      future = threadPoolTaskScheduler.schedule(new MyRunnable(), new Trigger(){
          @Override
          public Date nextExecutionTime(TriggerContext triggerContext){
              return new CronTrigger(cronStr).nextExecutionTime(triggerContext);
          }
      });

      System.out.println("startCron1 <<<<");
      return "startCron1";
  }
  
  // 在这里写需要在定时任务中处理的逻辑
  private class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("DynamicTask.MyRunnable.run()，" + new Date());
    }
 }
}
