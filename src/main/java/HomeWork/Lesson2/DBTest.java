package HomeWork.Lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager
                .getConnection("jdbc:sqlite:homework.db");
        Statement stmt = conn.createStatement();
        System.out.println(DBUtility.selectMaker(stmt));
        System.out.println(DBUtility.makerWithMaxProceeds(stmt));
    }
}
