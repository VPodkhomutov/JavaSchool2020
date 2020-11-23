package Lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class Date implements Command{

        @Override
        public String getName() {
            return "Текущая дата";
        }

        @Override
        public void execute() {
            System.out.println(getName() + ": "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.M.uuuu")));
        }
    }

