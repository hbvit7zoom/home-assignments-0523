import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.Assert;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.sberbank.jd.lesson12.webinar06.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BTest {

    PostgreSQLContainer postgreSqlContainer = new PostgreSQLContainer("postgres:13.9-alpine");

    @Test
    public void testSimpleSeclect() throws SQLException, LiquibaseException {
        postgreSqlContainer.start();
        String jdbcUrl = postgreSqlContainer.getJdbcUrl();
        String username = postgreSqlContainer.getUsername();
        String password = postgreSqlContainer.getPassword();

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl,
                    username,
                    password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));
        Liquibase liquibase = new Liquibase("db/changelog.xml", new ClassLoaderResourceAccessor(), database);
        liquibase.update();

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM book");
        resultSet.next();

        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");

        Book book = new Book(id, title, author);
        System.out.println(book);

        Assert.assertEquals(1, id);
        Assert.assertEquals("Преступление и наказание", title);
        Assert.assertEquals("Достоевский", author);
    }
}
