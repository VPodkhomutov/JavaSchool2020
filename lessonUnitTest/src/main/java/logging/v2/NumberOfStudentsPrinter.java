package logging.v2;

import logging.Student;
import org.apache.log4j.Logger;

import java.util.List;

public class NumberOfStudentsPrinter {
    Logger logger = Logger.getLogger(NumberOfStudentsPrinter.class.getName());

    public void printNumberOfAllStudentsPresent(List<Student> students) {
        //TODO Напечатать количество студентов, которые присутствовали на тесте (имеют оценку) с уровнем info
        int studentRated = 0;
        for (Student s : students) {
            if (s.getResult() == null) {
                continue;
            } else {
                studentRated++;
            }
        }
        logger.info("Студентов с оценками: " + studentRated);
        System.out.println("Студентов с оценками: " + studentRated);
    }

    public void printNumberOfStudentsWith5And4(List<Student> students) {
        //TODO Напечатать количество студентов, имеющих оценку 5, и имеющих оценку 4 (значения суммировать не надо). Записать необходимо в одну строку.
        // Лог должен выводиться с уровнем debug
        logger.debug("ДЕБАГ");
        int studentFive = 0;
        int studentFour = 0;
        for (Student s : students) {
            if (s.getResult() == null) {
                continue;
            } else {
                if (s.getResult().equals(5)) {
                    studentFive++;
                }
                if (s.getResult().equals(4)) {
                    studentFour++;
                }
            }
        }
        logger.info(studentFour+", " + studentFive);
        System.out.println("Студентов с оценками 4 и 5: " + studentFour+", " + studentFive);
    }
}
