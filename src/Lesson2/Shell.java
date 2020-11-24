package Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Command[] arrayCommands = new Command[]{new Time(), new Date(), new Exit()};
       Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите одну из доступных команд(time/date/exit):");
            String s = sc.nextLine();
            for (Command command: arrayCommands) {
                if (command.getName().toLowerCase().equals(s.toLowerCase())) {
                    execCommand(command) ;               }
            }
        }
    }
    public static void execCommand(Command c) {
        c.execute();
    }
}
