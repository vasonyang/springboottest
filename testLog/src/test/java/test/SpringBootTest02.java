package test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.io.UnsupportedEncodingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.test.ApplicationLogTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationLogTest.class)
public class SpringBootTest02 {

  @Autowired  
  private WebApplicationContext wac; 
  
  private MockMvc mvc;
  
  @Before
  public void setUp() {
    mvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }
  
  @Test
  public void test01() throws UnsupportedEncodingException, Exception {
    RequestBuilder requestBuilder = get("/user/getUserById").param("id", "meimei");
    String response = mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();
    System.out.println(response);
  }
}
