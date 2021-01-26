package newVersion;

import java.util.Scanner;

public class UserInput {

    public void userAction(){
        TableAction ta = new TableAction();
        Scanner sc = new Scanner(System.in);
        int sql_id;
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
                    if (ta.checkId(sql_id)) {
                        ta.getForId(sql_id);
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
                ta.insert(s);
                ta.viewAll();
            }
            if (s.trim().toLowerCase().equals("delete")) {
                System.out.println("Введите идентификатор строки:");
                s = sc.nextLine();
                try {
                    sql_id = Integer.parseInt(s);
                    if (ta.checkId(sql_id)) {
                        ta.delete(sql_id);
                    } else {
                        System.out.println("Такого идентификатора нет в таблице. Удаление невозможно");
                    }
                    ta.viewAll();
                } catch (Exception e) {
                    System.out.println("Введенный идентификатор не является числом");
                }
            }
            if (s.trim().toLowerCase().equals("update")) {
                System.out.println("Введите идентификатор строки:");
                s = sc.nextLine();
                try {
                    sql_id = Integer.parseInt(s);
                    if (!ta.checkId(sql_id)) {
                        System.out.println("Такого идентификатора нет в таблице. Обновление невозможно");
                    } else {
                        System.out.println("Введите новое значение name:");
                        s = sc.nextLine();
                        ta.update(sql_id, s);
                    }
                    ta.viewAll();
                } catch (Exception e) {
                    System.out.println("Введенный идентификатор не является числом");
                }
            }
        }
    }
}
