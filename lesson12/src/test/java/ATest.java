import org.junit.Assert;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ATest {

    PostgreSQLContainer postgreSqlContainer = new PostgreSQLContainer("postgres:13.9-alpine");

    @Test
    public void testSimpleSeclect() throws SQLException {
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

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT 1");
        resultSet.next();
        int result = resultSet.getInt(1);
        Assert.assertEquals(1, result);
    }
}
