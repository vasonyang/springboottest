package com.xingneng.learn.proxytest.jdkproxy;

import java.util.List;
import com.google.gson.Gson;
import com.test.logtest.bean.User;
import com.test.logtest.service.UserService;
import com.test.logtest.service.impl.UserServiceImpl;

public class TestJDKProxy {

  public static void main(String[] args) {
      UserService userService = (UserService) new JDKProxy(new UserServiceImpl()).getInstance();
      List<User> list = userService.getUserByName("la");
      Gson gson = new Gson();
      String userObjStr = gson.toJson(list);
      System.out.println(userObjStr);
  }
}
