package com.xingneng.learn.singlton;

public class StaticSingleton {

  private StaticSingleton () {
    System.out.println("StaticSingleton is created.");
  }
  
  // 当StaticSingleton 被加载时 内部类不会被初始化，故可以确保当StaticSingleton 类被加载入JVM时，不会初始化单例类，而当getInstance() 方法被调用时，才会加载SingletonHolder，从而初始化instance.
  private static class SingletonHolder {
    private static StaticSingleton instance = new  StaticSingleton();
  }
  
  private static StaticSingleton getInstance() {
    return SingletonHolder.instance;
  }
  
}
