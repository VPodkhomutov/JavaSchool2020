import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTable {

    static void getForId(int id_test, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM test where id = ?");)
            {   preparedStatement.setInt(1, id_test);
                ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                System.out.println("Строка #" + result.getRow()
                        + "\t ID=" + result.getInt("id")
                        + "\t name=" + result.getString("name"));
            }
            result.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
