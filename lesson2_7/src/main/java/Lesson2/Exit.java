package Lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exit implements Command{

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute() {
        System.out.println("Спасибо за использование программы Shell");
        System.exit(0);
    }
}
