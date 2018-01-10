package com.xingneng.learn.proxytest.cglibproxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMthodInterceptor implements MethodInterceptor{

  @Override
  public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("here in interceptor.");
    return methodProxy.invokeSuper(arg0, arg2);
  }


}
