package Lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exit implements Command{

    @Override
    public String getName() {
        return "Программа завершена";
    }

    @Override
    public void execute() {
        System.out.println(getName());
        System.exit(0);
    }
}
