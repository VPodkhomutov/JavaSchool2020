package Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Command[] arrayCommands = new Command[]{new Time(), new Date(), new Exit()};
        Scanner sc = new Scanner(System.in);
        int counter;
        while (true) {
            System.out.println("Введите одну из доступных команд(time/date/exit):");
            String s = sc.nextLine();
            counter = 0;
            for (Command command : arrayCommands) {
                if (command.getName().equals(s)) {
                    execCommand(command);
                    counter++;
                    break;
                }
            }
            if (counter==0){
                System.out.println("Данная команда не поддерживается в этой программе!");
            }
        }
    }

    public static void execCommand(Command c) {
        c.execute();
    }
}
