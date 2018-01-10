package com.xingneng.learn.proxytest.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler{

  private Object obj; // 被代理人
  
  public JDKProxy (Object obj) {
    this.obj = obj;
  }
  
  public Object getInstance() {
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
  }
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    
    return method.invoke(this.obj, args);
  }

}
