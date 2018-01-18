package com.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.test.dao.DaoTest;

public class test {

  public static void main(String[] args) {
    String sql = "select * from branches_user;";
    
    DaoTest dao = new DaoTest();
    try {
      List<Map<String, Object>> list = dao.getList(sql);
      System.out.println(list);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
