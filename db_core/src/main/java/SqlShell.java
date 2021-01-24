import java.sql.*;
import java.util.Scanner;

public class SqlShell {
    //  Database properties
    static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final String USER = "postgres";
    static final String PASS = "java";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver не найден ");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        int sql_id = 0;
        String sql_name = "";
        ResultSet result1 = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (connection != null) {
                System.out.println("Соединение с БД установлено");
                statement = connection.createStatement();
            } else {
                System.out.println("Нет коннекта до БД");
            }
            result1 = statement.executeQuery("select * from test order by 1");
            System.out.println("Текущее состояние таблицы:");
            while (result1.next()) {
                System.out.println("Строка #" + result1.getRow()
                        + "\t ID=" + result1.getInt("id")
                        + "\t name=" + result1.getString("name")
                );
            }

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Введите одну из доступных команд(select/insert/update/delete/exit):");
                String s = sc.nextLine();
                if (s.equals("exit")) {
                    System.exit(0);
                }
                if (s.equals("select")) {
                    System.out.println("Введите идентификатор строки:");
                    s = sc.nextLine();
                    try {
                        sql_id = Integer.parseInt(s);
                        preparedStatement = connection.prepareStatement("SELECT * FROM test where id = ? ");
                        //Устанавливаем в нужную позицию значения определённого типа
                        preparedStatement.setInt(1, sql_id);
                        //выполняем запрос
                        result = preparedStatement.executeQuery();
                        System.out.println("Результат SELECT");
                        while (result.next()) {
                            System.out.println("Строка #" + result.getRow()
                                    + "\t ID=" + result.getInt("id")
                                    + "\t name=" + result.getString("name"));
                        }
                    } catch (Exception e) {
                        System.out.println("Это не число");
                    }
                }
                if (s.equals("insert")) {
                    System.out.println("Введите name:");
                    s = sc.nextLine();
                    preparedStatement = connection.prepareStatement(
                            "INSERT INTO test(name) values(?)");
                    preparedStatement.setString(1, s);
                    preparedStatement.executeUpdate();

                    result1 = statement.executeQuery("select * from test order by 1");
                    System.out.println("Результат INSERT");
                    while (result1.next()) {
                        System.out.println("Строка #" + result1.getRow()
                                + "\t ID=" + result1.getInt("id")
                                + "\t name=" + result1.getString("name")
                        );
                    }
                }
                if (s.equals("delete")) {
                    System.out.println("Введите идентификатор строки:");
                    s = sc.nextLine();
                    try {
                        sql_id = Integer.parseInt(s);
                        preparedStatement = connection.prepareStatement(
                                " delete from test where id=?");
                        preparedStatement.setInt(1, sql_id);
                        preparedStatement.executeUpdate();

                        result1 = statement.executeQuery("select * from test order by 1");
                        System.out.println("Результат DELETE");
                        while (result1.next()) {
                            System.out.println("Результат #" + result1.getRow()
                                    + "\t ID=" + result1.getInt("id")
                                    + "\t name=" + result1.getString("name")
                            );
                        }
                    } catch (Exception e) {
                        System.out.println("Это не число");
                    }
                }
                if (s.equals("update")) {
                    System.out.println("Введите идентификатор строки:");
                    s = sc.nextLine();
                    try {
                        sql_id = Integer.parseInt(s);
                        System.out.println("Введите новое значение name:");
                        s = sc.nextLine();
                        preparedStatement = connection.prepareStatement(
                                "update test set name =? where id=?");
                        preparedStatement.setString(1, s);
                        preparedStatement.setInt(2, sql_id);
                        preparedStatement.executeUpdate();

                        result1 = statement.executeQuery("select * from test order by 1");
                        System.out.println("Результат UPDATE");
                        while (result1.next()) {
                            System.out.println("Результат #" + result1.getRow()
                                    + "\t ID=" + result1.getInt("id")
                                    + "\t name=" + result1.getString("name")
                            );
                        }
                    } catch (Exception e) {
                        System.out.println("Это не число");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
