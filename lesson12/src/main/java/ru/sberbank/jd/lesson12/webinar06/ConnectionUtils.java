package ru.sberbank.jd.lesson12.webinar06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db",
                    "user",
                    "pass");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return  connection;
    }
}
