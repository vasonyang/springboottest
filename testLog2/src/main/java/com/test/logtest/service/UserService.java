package com.test.logtest.service;

import java.util.List;
import com.test.logtest.bean.User;

public interface UserService {

  User getUserById(String id);
  List<User> getUserByName(String name);
  int insertUser(User user);
}
