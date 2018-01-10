package com.xingneng.learn.proxytest.cglibproxy;

import com.google.gson.Gson;
import com.test.logtest.bean.User;
import com.test.logtest.service.UserService;
import com.test.logtest.service.impl.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;

public class TestCGlibproxy {

  public static void main(String[] args) {
    MyMthodInterceptor mthodInterceptor = new MyMthodInterceptor();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(UserServiceImpl.class);
    enhancer.setCallback(mthodInterceptor);
    
    UserService userService = (UserService)enhancer.create();
    User user = userService.getUserById("1");
    Gson gson = new Gson();
    String userObjStr = gson.toJson(user);
    System.out.println(userObjStr);
  }
}
