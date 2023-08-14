package lesson44.dao;

public class DaoTester {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        System.out.println(
                userDAO.createUser("Semen", "Dejnev")
        );
    }
}
