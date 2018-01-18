package com.test.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;

public class GetDataSources {

  private static DB db = new DB();
  
  static {  
    Properties prop = new Properties();  
    InputStream in =  null;
    try {  
      in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
      prop.load(in);  
      db.setDriver(prop.getProperty("dbcp.driver"));
      db.setUrl0(prop.getProperty("dbcp.url"));
      db.setUsername0(prop.getProperty("dbcp.username"));
      db.setPassword0(prop.getProperty("dbcp.password"));
      db.setInitialSize(Integer.valueOf(prop.getProperty("dbcp.initialSize")));
      db.setMaxActive(Integer.valueOf(prop.getProperty("dbcp.maxActive")));
      db.setMaxIdle(Integer.valueOf(prop.getProperty("dbcp.maxIdle")));
      db.setMinIdle(Integer.valueOf(prop.getProperty("dbcp.minIdle")));
      db.setMaxWait(Long.valueOf(prop.getProperty("dbcp.maxWait")));
      db.setValidationQuery(prop.getProperty("dbcp.validationQuery"));
      db.setValidationQueryTimeout(Integer.valueOf(prop.getProperty("dbcp.validationQueryTimeout")));
      db.setTestWhileIdle(Boolean.valueOf(prop.getProperty("dbcp.testWhileIdle")));
      db.setTestOnBorrow(Boolean.valueOf(prop.getProperty("dbcp.testOnBorrow")));
      db.setTimeBetweenEvictionRunsMillis(Integer.valueOf(prop.getProperty("dbcp.timeBetweenEvictionRunsMillis")));
      db.setNumTestsPerEvictionRun(Integer.valueOf(prop.getProperty("dbcp.numTestsPerEvictionRun")));
      db.setMinEvictableIdleTimeMillis(Integer.valueOf(prop.getProperty("dbcp.minEvictableIdleTimeMillis")));
      db.setRemoveAbandoned(Boolean.valueOf(prop.getProperty("dbcp.removeAbandoned")));
      db.setRemoveAbandonedTimeout(Integer.valueOf(prop.getProperty("dbcp.removeAbandonedTimeout")));
    } catch (Exception e) {  
        e.printStackTrace();  
    }finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
}
  
  public static DataSource dataSource() {
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(db.getDriver());
    basicDataSource.setUrl(db.getUrl0());
    basicDataSource.setUsername(db.getUsername0());
    basicDataSource.setPassword(db.getPassword0());
    basicDataSource.setInitialSize(db.getInitialSize());
    basicDataSource.setMaxTotal(db.getMaxActive());
    basicDataSource.setMaxIdle(db.getMaxIdle());
    basicDataSource.setMinIdle(db.getMinIdle());
    basicDataSource.setMaxWaitMillis(db.getMaxWait());
    basicDataSource.setValidationQuery(db.getValidationQuery());
    basicDataSource.setValidationQueryTimeout(db.getValidationQueryTimeout());
    basicDataSource.setTestWhileIdle(db.isTestWhileIdle());
    basicDataSource.setTestOnBorrow(db.isTestOnBorrow());
    basicDataSource.setTimeBetweenEvictionRunsMillis(db.getTimeBetweenEvictionRunsMillis());
    basicDataSource.setNumTestsPerEvictionRun(db.getNumTestsPerEvictionRun());
    basicDataSource.setMinEvictableIdleTimeMillis(db.getMinEvictableIdleTimeMillis());
    basicDataSource.setRemoveAbandonedOnBorrow(db.isRemoveAbandoned());
    basicDataSource.setRemoveAbandonedTimeout(db.getRemoveAbandonedTimeout());
    return basicDataSource;
  }
}
