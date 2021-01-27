package newVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectCreate {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "postgres";
    private static final String PASS = "java1";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Нет коннекта до БД");
        }
        return connection;
    }

    public void closeConnection(Connection conn){
        try{
            conn.close();
            System.out.println("Закрыли соединение");
        } catch (SQLException e ){
            e.printStackTrace();
        }

    }

}
