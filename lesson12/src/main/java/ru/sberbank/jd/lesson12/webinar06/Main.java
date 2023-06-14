package ru.sberbank.jd.lesson12.webinar06;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionUtils.getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from book");

            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString(2);
//                String author = resultSet.getString(3);

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");

                Book book = new Book(id, title, author);

                System.out.println(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
