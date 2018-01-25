package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.test.ApplicationLogTest;
import com.test.logtest.bean.User;
import com.test.logtest.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationLogTest.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebMvc
public class SpringBootTest01 {

  @Autowired
  private TestRestTemplate restTemplate;
  
  @Autowired
  private UserService userService;

  @Test
  public void userTest2() throws Exception {
    User user = restTemplate.getForObject("/user/getUserById?id=meimei", User.class);
    Assert.assertEquals("meimei", user.getId());
  }
}
