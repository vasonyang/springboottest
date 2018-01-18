package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.sql.DataSource;
import com.test.db.GetDataSources;

public class DaoTest {
  private static final Logger logger = Logger.getLogger("datasource");
  private static DataSource dataSource = GetDataSources.dataSource();
  
  public List<Map<String, Object>> getList(String sql) throws SQLException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    try {
      conn = dataSource.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int size = rsmd.getColumnCount();

      while (rs.next()) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 1; i <= size; i++) {
          String name = rsmd.getColumnLabel(i);
          Object obj = rs.getObject(name);
          map.put(name, obj);
        }
        list.add(map);
      }
    } catch (SQLException e) {
      throw new SQLException(e.getMessage());
    } finally {
      rs = closeResultSet(rs);
      stmt = closeStmt(stmt);
      conn = closeConn(conn);
    }
    return list;
  }

  /**
   * 功能描述:回滚
   */
  public void rollback(Connection conn) {
    if (conn != null) {
      try {
        conn.rollback();
      } catch (SQLException e) {
//        logger..error("数据回滚失败", e);
      }
    }
  }

  /**
   * 功能描述:关闭连接
   */
  public Connection closeConn(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
//        logger.error("关闭连接失败", e);
      } finally {
        conn = null;
      }
    }
    return conn;
  }

  /**
   * 功能描述:关闭statement
   */
  public PreparedStatement closePreStmt(PreparedStatement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (SQLException e) {
//        logger.error("关闭PreparedStatement失败", e);
      } finally {
        stmt = null;
      }
    }
    return stmt;
  }

  /**
   * 功能描述:关闭结果集
   */
  public ResultSet closeResultSet(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
//        logger.error("关闭ResultSet失败", e);
      } finally {
        rs = null;
      }
    }
    return rs;
  }

  public Statement closeStmt(Statement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (SQLException e) {
//        logger.error("关闭Statement失败", e);
      } finally {
        stmt = null;
      }
    }
    return stmt;
  }

  public void commit(Connection conn) throws SQLException {
    logger.info("提交事务");
    if (conn != null) {
      conn.commit();
    }
  }
}
