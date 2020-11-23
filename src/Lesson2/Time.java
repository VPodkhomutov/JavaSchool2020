package Lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time implements Command{

    @Override
    public String getName() {
        return "Текущее время";
    }

    @Override
    public void execute() {
        System.out.println(getName() + ": "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
