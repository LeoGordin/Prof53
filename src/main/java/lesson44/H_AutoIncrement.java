package lesson44;

import java.sql.*;

public class H_AutoIncrement {
    // create table users (id integer not null primary key autoincrement, first text, last text);
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                Statement stmt = conn.createStatement(); // запрос
        ) {
            int rowsAffected = stmt.executeUpdate(
                    "insert into users (first, last) values ('Max', 'Kotkov'); "
            );
            if(rowsAffected > 0)
            {
                try(
                        ResultSet rs = stmt.getGeneratedKeys();
                )
                {
                    if(rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("Inserted id is: " + id);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
