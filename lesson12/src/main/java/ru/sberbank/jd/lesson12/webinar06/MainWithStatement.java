package ru.sberbank.jd.lesson12.webinar06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainWithStatement {

    public static void main(String[] args) {
        Connection connection = ConnectionUtils.getConnection();

        try (Statement statement = connection.createStatement()){

            String query = "select * from book where author like \'Пушкин\'; drop table book";
            boolean execute = statement.execute(query);
            System.out.println(execute);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
