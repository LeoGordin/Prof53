package lesson44.dao;

import java.sql.*;
import java.util.List;

public class UserDAO {

    private static String url = "jdbc:sqlite:shop.db";

    public UserDAO() {
    }

    public User getUserById(int id)
    {
        return null;
    }
    public List<User> getAll()
    {
        return null;
    }

    public User createUser(String first, String last)
    {
        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                PreparedStatement stmt = conn.prepareStatement(
                        "insert into users (first, last) values (?, ?); "
                ); // запрос
        ) {
            stmt.setString(1, first);
            stmt.setString(2, last);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0)
            {
                try(
                        ResultSet rs = stmt.getGeneratedKeys();
                )
                {
                    if(rs.next()) {
                        int id = rs.getInt(1);
                        // System.out.println("Inserted id is: " + id);
                        User u =  new User(first, last);
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
    public void delete(User u)
    {

    }
    public void update(User u)
    {

    }
}
