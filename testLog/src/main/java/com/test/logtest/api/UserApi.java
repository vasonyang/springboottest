package com.test.logtest.api;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.logtest.bean.User;
import com.test.logtest.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserApi {
  
  private Logger logger = LoggerFactory.getLogger(UserApi.class);
  
  @Autowired
  UserService userService;

  @RequestMapping(value = "/getUserById", method=RequestMethod.GET)
  public User getUserById(@RequestParam String id) {
    logger.info("in to getUserById method.");
    if (id == null || id.isEmpty()) {
      logger.warn("the id is null or empty!");
      return new User();
    }
    User user = userService.getUserById(id);
    logger.info("out of getUserById method.");
    return user;
  }
  
  @RequestMapping(value = "/getUserByName", method=RequestMethod.GET)
  public List<User> getUserByName(@RequestParam String name) {
    logger.info("in to getUserByName method.");
    if (name == null || name.isEmpty()) {
      logger.warn("the name is null or empty!");
      return Collections.emptyList();
    }
    List<User> list = userService.getUserByName(name);
    logger.info("out of getUserByName method.");
    return list;
  }
  
  
  
}
