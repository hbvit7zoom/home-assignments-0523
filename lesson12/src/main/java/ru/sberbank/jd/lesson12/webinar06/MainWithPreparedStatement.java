package ru.sberbank.jd.lesson12.webinar06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainWithPreparedStatement {

    public static void main(String[] args) {
        Connection connection = ConnectionUtils.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from book where author like ?")){
            preparedStatement.setString(1, "\'Пушкин\'; drop table book");
            boolean execute = preparedStatement.execute();
            System.out.println(execute);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
