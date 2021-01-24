import java.sql.*;
import java.util.Scanner;

public class SqlShell {
    //  Database properties
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "postgres";
    private static final String PASS = "java";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver не найден ");
            e.printStackTrace();
            return;
        }
        try ( Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);)
            {
            if (connection != null) {
                int sql_id = 0;
                System.out.println("Соединение с БД установлено");
                SelectAll.soutAll(connection);
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println("Введите одну из доступных команд(select/insert/update/delete/exit):");
                    String s = sc.nextLine();
                    if (s.trim().toLowerCase().equals("exit")) {
                        System.exit(0);
                    }
                    if (s.trim().toLowerCase().equals("select")) {
                        System.out.println("Введите идентификатор строки:");
                        s = sc.nextLine();
                        try {
                            sql_id = Integer.parseInt(s);
                            if (CheckId.checkId(sql_id, connection)) {
                                SelectTable.getForId(sql_id,connection);
                            } else {
                                System.out.println("Такого идентификатора нет в таблице");
                            }
                        } catch (Exception e) {
                            System.out.println("Введенный идентификатор не является числом");
                        }
                    }
                    if (s.trim().toLowerCase().equals("insert")) {
                        System.out.println("Введите name:");
                        s = sc.nextLine();
                        InsertTable.insName(s, connection);
                        SelectAll.soutAll(connection);
                    }
                    if (s.trim().toLowerCase().equals("delete")) {
                        System.out.println("Введите идентификатор строки:");
                        s = sc.nextLine();
                        try {
                            sql_id = Integer.parseInt(s);
                            if (CheckId.checkId(sql_id, connection)) {
                                DeleteTable.delForId(sql_id,connection);
                            } else {
                                System.out.println("Такого идентификатора нет в таблице. Удаление невозможно");
                            }
                            SelectAll.soutAll(connection);
                        } catch (Exception e) {
                            System.out.println("Введенный идентификатор не является числом");
                        }
                    }
                    if (s.trim().toLowerCase().equals("update")) {
                        System.out.println("Введите идентификатор строки:");
                        s = sc.nextLine();
                        try {
                            sql_id = Integer.parseInt(s);
                            System.out.println("Введите новое значение name:");
                            s = sc.nextLine();
                            UpdateTable.UpdForId(sql_id,s, connection);
                            SelectAll.soutAll(connection);
                        } catch (Exception e) {
                            System.out.println("Введенный идентификатор не является числом");
                        }
                    }
                }
            } else {
                System.out.println("Нет коннекта до БД");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /*finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }*/
    }
}
