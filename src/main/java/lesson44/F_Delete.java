package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class F_Delete {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                Statement stmt = conn.createStatement(); // запрос
        ) {
            // удалим все заказы с датой 1990-10-03
            int rowsDeleted =  stmt.executeUpdate("delete from orders where odate = '1990-10-03'; ");
            System.out.println("Rows deleted: " + rowsDeleted);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
