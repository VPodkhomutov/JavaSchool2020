package newVersion;

import java.sql.*;

public class TableAction {
    void delete(int id){
        try (   Connection connection = ConnectCreate.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(" delete from test where id=?");)
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Строка с идентификатором "+id+ " удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insert(String value){
        try (   Connection connection = ConnectCreate.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO test(name) values(?)");)
        {
            preparedStatement.setString(1, value);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void update(int id, String value) {
        try (   Connection connection = ConnectCreate.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("update test set name =? where id=?");)
        {
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean checkId(int id) {
        try (   Connection connection = ConnectCreate.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(1) as cnt FROM test where id = ?"); )
        {
            preparedStatement.setInt(1, id);
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

    void getForId(int id) {
        try (   Connection connection = ConnectCreate.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM test where id = ?");)
        {   preparedStatement.setInt(1, id);
         try (ResultSet result = preparedStatement.executeQuery();) {
             while (result.next()) {
                 System.out.println("Строка #" + result.getRow()
                         + "\t ID=" + result.getInt("id")
                         + "\t name=" + result.getString("name"));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() {
        try (   Connection connection = ConnectCreate.getConnection();
                Statement statement = connection.createStatement();
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
