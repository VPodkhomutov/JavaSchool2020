import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTable {

    static void delForId(int sql_id, Connection connection) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(" delete from test where id=?");)
        {
            preparedStatement.setInt(1, sql_id);
            preparedStatement.executeUpdate();
            System.out.println("Строка с идентификатором "+sql_id+ " удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
