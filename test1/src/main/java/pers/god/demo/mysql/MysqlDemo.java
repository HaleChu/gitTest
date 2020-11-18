package pers.god.demo.mysql;

import java.sql.*;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/13
 */
public class MysqlDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://192.168.217.128:3306/mysql1?useSSL=false&useUnicode=true", "root", "123456");
            statement = connection.createStatement();
            String sql = "select * from class";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int roomNo = resultSet.getInt("roomNo");
                System.out.println("班级序号:" + id + "班级名称:" + name + "班级教室号:" + roomNo);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
