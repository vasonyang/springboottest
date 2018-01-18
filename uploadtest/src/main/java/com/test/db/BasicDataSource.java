/**
 * 文件名: BasicDataSource.java
 * 包路径: cn.newsframework.aop.factory
 * 创建描述
 *
 * @createPerson：牛鹏宇
 * @createDate：2016-11-28 下午5:03:44 内容描述： 修改描述
 * @updatePerson：牛鹏宇
 * @updateDate：2016-11-28 下午5:03:44 修改内容: 版本: V1.0
 */
package com.test.db;

import java.sql.Connection;
import java.sql.SQLException;


public class BasicDataSource extends org.apache.commons.dbcp2.BasicDataSource {

  public Connection getConnection() throws SQLException {
    Connection conn = super.getConnection();
    conn.setAutoCommit(true);
    return conn;
  }
}


