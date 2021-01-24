import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAll {

    static void soutAll(Connection connection) throws SQLException {
        try (   Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("select * from test order by 1");)
            {
            System.out.println("Текущее состояние таблицы:");
            while (result.next()) {
                System.out.println("Строка #" + result.getRow()
                        + "\t ID=" + result.getInt("id")
                        + "\t name=" + result.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
