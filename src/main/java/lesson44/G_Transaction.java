package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class G_Transaction {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";

        try (
                Connection conn = DriverManager.getConnection(url); // соединение
                Statement stmt = conn.createStatement(); // запрос
        ) {
            // conn.commit(); // транзакция выполнилась успешно
            // conn.rollback(); // сигнализируем базе данных что транзакцию нужно откатить
            // по-умолчанию у соединения устанавливается режим autoCommit=true
            // что означает что каждый запрос представляет собой отдельную транзакцию
            // что воспользоваться транзакциями для нескольких запросов его нужно отключить
            conn.setAutoCommit(false);
            // добавим нового кастомера
            stmt.execute("insert into customers (cnum, cname, city, rating, snum) " +
                    " values (4001, 'Ferguson', 'Berlin', 100, 1001 );   ");
            // вызовем исключение
            // System.out.println(4/0);
            stmt.execute("insert into orders (onum, amt, odate, cnum, snum) " +
                    " values (7001, 150000, '2023-08-08', 4001, 1001) ; ");
            conn.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
