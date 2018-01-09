package com.xingneng.learn.singlton;

public class LazySingleton {

  private LazySingleton () {
    System.out.println("LazySingleton is created." );
  }
  
  private static LazySingleton instance = null;
  
  // 这种方式在多线程时耗时远远大于SimpleSingleton 影响性能
  public static synchronized LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }
}
