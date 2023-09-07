package lesson44.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static String url = "jdbc:sqlite:shop.db";

    public UserDAO() {
    }

    public User getUserById(int id) {
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                PreparedStatement stmt = conn.prepareStatement(
                        "select id, first, last from  users where id=?; "
                ); // запрос
        ) {
            stmt.setInt(1, id);
            try (
                    ResultSet rs = stmt.executeQuery()
            ) {
                if (rs.next()) {
                    String first = rs.getString("first");
                    String last = rs.getString("last");
                    User u = new User(first, last);
                    u.setId(id);
                    return u;
                } else
                    return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                PreparedStatement stmt = conn.prepareStatement(
                        "select id, first, last from  users ; "
                ); // запрос
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String first = rs.getString("first");
                String last = rs.getString("last");
                User u = new User(first, last);
                u.setId(id);
                users.add(u);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    public User createUser(String first, String last) {
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                PreparedStatement stmt = conn.prepareStatement(
                        "insert into users (first, last) values (?, ?); "
                ); // запрос
        ) {
            stmt.setString(1, first);
            stmt.setString(2, last);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (
                        ResultSet rs = stmt.getGeneratedKeys();
                ) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        // System.out.println("Inserted id is: " + id);
                        User u = new User(first, last);
                        u.setId(id);
                        return u;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public int delete(User u) {
        if (u != null) {
            try (
                    Connection conn = DriverManager.getConnection(url); // соединение
                    PreparedStatement stmt = conn.prepareStatement(
                            "delete from users where id=?; "
                    ); // запрос
            ) {
                stmt.setInt(1, u.getId());
                return stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }

    public int update(User u) {
        if(u != null) {
            try (
                    Connection conn = DriverManager.getConnection(url); // соединение
                    PreparedStatement stmt = conn.prepareStatement(
                            "update users set first =?, last =? where id=? ; "
                    ); // запрос
            ) {
                stmt.setString(1, u.getFirst());
                stmt.setString(2, u.getLast());
                stmt.setInt(3, u.getId());
                return stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }

}
