package newVersion;

import java.util.Scanner;

public class UserInput {

    public void userAction(){
        TableAction ta = new TableAction();
        Scanner sc = new Scanner(System.in);
        int sqlId;
        while (true) {
            System.out.println("Введите одну из доступных команд(select/insert/update/delete/exit):");
            String s = sc.nextLine();
            if ("exit".equalsIgnoreCase(s)) {
                System.exit(0);
            }
            if ("select".equalsIgnoreCase(s)) {
                System.out.println("Введите идентификатор строки:");
                s = sc.nextLine();
                try {
                    sqlId = Integer.parseInt(s);
                    if (ta.checkId(sqlId)) {
                        ta.getForId(sqlId);
                    } else {
                        System.out.println("Такого идентификатора нет в таблице");
                    }
                } catch (Exception e) {
                    System.out.println("Введенный идентификатор не является числом");
                }
            }
            if ("insert".equalsIgnoreCase(s)) {
                System.out.println("Введите name:");
                s = sc.nextLine();
                ta.insert(s);
                ta.viewAll();
            }
            if ("delete".equalsIgnoreCase(s)) {
                System.out.println("Введите идентификатор строки:");
                s = sc.nextLine();
                try {
                    sqlId = Integer.parseInt(s);
                    if (ta.checkId(sqlId)) {
                        ta.delete(sqlId);
                    } else {
                        System.out.println("Такого идентификатора нет в таблице. Удаление невозможно");
                    }
                    ta.viewAll();
                } catch (Exception e) {
                    System.out.println("Введенный идентификатор не является числом");
                }
            }
            if ("update".equalsIgnoreCase(s)) {
                System.out.println("Введите идентификатор строки:");
                s = sc.nextLine();
                try {
                    sqlId = Integer.parseInt(s);
                    if (!ta.checkId(sqlId)) {
                        System.out.println("Такого идентификатора нет в таблице. Обновление невозможно");
                    } else {
                        System.out.println("Введите новое значение name:");
                        s = sc.nextLine();
                        ta.update(sqlId, s);
                    }
                    ta.viewAll();
                } catch (Exception e) {
                    System.out.println("Введенный идентификатор не является числом");
                }
            }
        }
    }
}
