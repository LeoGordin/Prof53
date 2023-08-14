package lesson44;

import java.sql.*;

public class B_CreateTables {
    public static void main(String[] args) {
        // Statement - запрос который можно выполнить имея соединение с базой данных
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                Statement stmt = conn.createStatement(); // запрос
        ) {
            stmt.execute("create table salespeople (snum int primary key not null, sname text not null, city " +
                    " text not null, comm integer not null); ");
            System.out.println("Table salespeople created");

            stmt.execute("create table customers (cnum int primary key not null, cname text not null, city " +
                    " text not null, rating integer not null, snum int not null); ");
            System.out.println("Table customers created");

            stmt.execute("create table orders (onum int primary key not null, amt int not null, odate text " +
                    " not null, cnum int not null, snum int not null); ");
            System.out.println("Table orders created");


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
