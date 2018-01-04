package com.test.logtest.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.test.logtest.bean.User;
import com.test.logtest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public User getUserById(String id) {
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
//    JsonObject obj = new JsonObject();
//    obj.addProperty("code", 200);
//    obj.addProperty("result", "success");
    return 1;
  }

}
