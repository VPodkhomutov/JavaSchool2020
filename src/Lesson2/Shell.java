package Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        String[] cmnd = new String[]{"time", "date", "exit"};
        Time t = new Time();
        Date d = new Date();
        Exit e = new Exit();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите одну из доступных команд(time/date/exit):");
            String s = sc.nextLine();
            if (Arrays.asList(cmnd).contains(s)) {
                if (s.equals("time")) {
                   execCommand(t);
                } else if (s.equals("date")) {
                    execCommand(d);
                } else if (s.equals("exit")) {
                    execCommand(e);
                }
            } else {
                System.out.println("Данная команда не поддерживается");
            }
        }

    }
    public static void execCommand(Command c) {
        c.execute();
    }
}
