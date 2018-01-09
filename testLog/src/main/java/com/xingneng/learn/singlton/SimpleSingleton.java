package com.xingneng.learn.singlton;

public class SimpleSingleton {

  private SimpleSingleton() {
    System.out.println(" SimpleSingleton instance created.");
  }
  
  private static SimpleSingleton instance = new SimpleSingleton();
  
  public static SimpleSingleton getInstance() {
    return instance;
  }
  
  // 当调用这个方法时，可能不需要类的实例但是无论何时需要使用这个方法时都会加载这个类从而创建类的实例。
  public static String getSomeString() {
    return "return some string to you.";
  }
  
}
