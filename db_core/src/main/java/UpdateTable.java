import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {

    static void UpdForId(int sql_id, String sql_str, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("update test set name =? where id=?");)
        {
            preparedStatement.setString(1, sql_str);
            preparedStatement.setInt(2, sql_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
