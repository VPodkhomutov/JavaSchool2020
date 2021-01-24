import java.sql.*;

class CheckId {

    static boolean checkId(int id_test, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(1) as cnt FROM test where id = ?"); )
        {
            preparedStatement.setInt(1, id_test);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            result.getRow();
            return result.getInt("cnt")!=0;
            //как здесь сделать result.close???
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
