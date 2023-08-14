package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class E_Update {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                Statement stmt = conn.createStatement(); // запрос
        ) {
            int rowsAffected = stmt.executeUpdate(" update salespeople set comm = comm + 2 ;");

            System.out.println("Rows updated: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
