import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertTable {

    static void insName(String name, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO test(name) values(?)");)
        {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
