package com.bigdata.hive.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 使用前必须开启hiveserver2
 * 利用jdbc的方式访问hiveserver2
 */
public class HiveJdbc {
    public static void main(String[] args) throws Exception {
        //加载驱动（hive会自动读取驱动，可省略）
//        Class.forName("org.apache.hive.jdbc.HiveDriver");

         //创建连接
        Connection connection = DriverManager.getConnection("jdbc:hive2://localhost1:10000", "root", "");

        //准备sql
        String sql="select * from default.test";

        //预编译sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getInt("id")+" -- "+resultSet.getString("name"));
        }
    }
}
