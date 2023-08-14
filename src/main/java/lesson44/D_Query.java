package lesson44;

import java.sql.*;

public class D_Query {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                Statement stmt = conn.createStatement(); // запрос
                ResultSet rs = stmt.executeQuery(" select * from customers order by cname ");
                PreparedStatement pstmt = conn.prepareStatement("select * from salespeople where comm > ? ");
                PreparedStatement opstmt = conn.prepareStatement("select * from orders where amt > ? and amt < ? ");
        ) {
            while (rs.next()) {
                int customerId = rs.getInt("cnum");
                String name = rs.getString("cname");
                String city = rs.getString("city");
                int rating = rs.getInt("rating");
                int snum = rs.getInt("snum");

                System.out.printf("|%5d|%10s|%10s|%5d|%5d|\n",
                        customerId, name, city, rating, snum);
            }

            System.out.println("===========");
            pstmt.setInt(1, 11); // все продавцы с комиссией больше 11 процентов
            try (
                    ResultSet rsSales = pstmt.executeQuery();
            ) {
                while (rsSales.next()) {
                    int snum = rsSales.getInt("snum");
                    String sname = rsSales.getString("sname");
                    String city = rsSales.getString("city");
                    int comm = rsSales.getInt("comm");
                    System.out.printf("|%5d|%10s|%10s|%5d|\n", snum, sname, city, comm);
                }
            }

            // распечатайте все заказы стоимостью от 100000 до 200000
            // с помощью параметризованного запроса
            System.out.println("===========");
            opstmt.setInt(1, 100_000);
            opstmt.setInt(2, 200_000);
            try (
                    ResultSet rsOrders = opstmt.executeQuery();
                    )
            {
                while (rsOrders.next()) {
                    int onum = rsOrders.getInt("onum");
                    int amt = rsOrders.getInt("amt");
                    String odate = rsOrders.getString("odate");
                    int cnum = rsOrders.getInt("cnum");
                    int snum = rsOrders.getInt("snum");
                    System.out.printf("|%5d|%10d|%10s|%5d|%5d|\n", onum, amt, odate, cnum, snum);
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
