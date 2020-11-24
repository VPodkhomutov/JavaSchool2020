package Lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time implements Command{

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public void execute() {
        System.out.println("Текущее время: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
