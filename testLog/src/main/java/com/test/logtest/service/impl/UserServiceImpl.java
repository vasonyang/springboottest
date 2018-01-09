package com.test.logtest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.test.logtest.bean.User;
import com.test.logtest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  Logger logger = LoggerFactory.getLogger("testNameLog"); // 去logback-spring.xml 中查找  name 为  testNameLog 的logger 
  @Override
  public User getUserById(String id) {
    logger.info("根据id获取用户服务");
    User user = new User();
    user.setId(id);
    user.setName("啊立刻就");
    user.setAge(25);
    user.setGender("男");
    user.setBirthDate(new Date());
    Gson gson = new Gson();
    String userObjStr = gson.toJson(user);
    System.out.println(userObjStr);
//    JsonObject obj = new JsonObject();
//    obj.addProperty("user", userObjStr);
//    obj.addProperty("code", 200);
    return user;
  }

  @Override
  public List<User> getUserByName(String name) {
    logger.info("根据name获取用户服务");
    List<User> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      User user = new User();
      user.setId("thisIsId_" + i);
      user.setName(name + "_" + i);
      user.setAge(25);
      user.setGender("男");
      user.setBirthDate(new Date());
      list.add(user);
    }
    Gson gson = new Gson();
    String userObjStr = gson.toJson(list);
    System.out.println(userObjStr);
//    JsonObject obj = new JsonObject();
//    obj.addProperty("user", userObjStr);
//    obj.addProperty("code", 200);
    return list;
  }

  @Override
  public int insertUser(User user) {
    logger.info("插入用户服务");
//    JsonObject obj = new JsonObject();
//    obj.addProperty("code", 200);
//    obj.addProperty("result", "success");
    

    return 1;
  }

//  public static void main(String[] args) {
//    String date = LocalDate.now().plusDays(1).toString();
//    System.out.println(date);
//    
//    String date2 = LocalDate.now().minusYears(1).toString();
//    System.out.println(date2);
//  }
}
