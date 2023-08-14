package lesson44;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A_CreateDatabase {
    public static void main(String[] args) {
        // JDBC - Java DataBase Connectivity
        // URL базы данных + логин/пароль + настроечные параметры
        // http://www.google.com
        // tel:123
        // jdbc:oracle:thin:@localhost:1521:xe
        String url = "jdbc:sqlite:shop.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//            // TODO some work
//        } catch (SQLException e)
//        {
//            System.err.println(e.getMessage());
//        }
//        finally {
//            if(conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }

        try (
                // так как Connection имплементит AutoCloseable, для
                // него будет автоматически вызыван close() при выходе из try-блока
                Connection conn = DriverManager.getConnection(url);
        ) {
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("The driver is: " + metaData.getDriverName());
            System.out.println("Database was created");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
