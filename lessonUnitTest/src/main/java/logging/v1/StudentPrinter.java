package logging.v1;

import logging.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

public class StudentPrinter {
    Logger logger = Logger.getLogger(StudentPrinter.class.getName());
    public void printAllNotPresentStudents(List<Student> students) {
        //TODO Напечатать список всех студентов, которые отсутствовали на тесте (нет оценки) с уровнем warn
       String studentLigger = "";
        for (Student s:students) {
            if (s.getResult()==null) {
                studentLigger = studentLigger+s.getFirstName()+" "+s.getLastName()+", ";
            }
        }
        logger.warn("Прогульщики: "+studentLigger.substring(0,studentLigger.length()-2));
        System.out.println("Прогульщики: "+studentLigger.substring(0,studentLigger.length()-2));
    }

    public void printAllStudents(List<Student> students) {
        //TODO Напечатать список всех студентов с уровнем info
        int cnt = students.size();
        String allStudents[] = new String[cnt];
        Student tmp;
        for (int i=0;i<students.size();i++) {
            tmp = students.get(i);
            allStudents[i] = tmp.getFirstName()+" "+tmp.getLastName();
        }
        logger.info("Все студенты: "+ Arrays.toString(allStudents));
        System.out.println("Все студенты: "+ Arrays.toString(allStudents));
    }

    public void printAllStudentsWith2(List<Student> students) {
        //TODO Напечатать список всех студентов, которые имеют оценку 2 c уровнем error
        String studentLagging = "";
        for (Student s:students) {
            if (s.getResult()==null) {continue;}
            if (s.getResult().equals(2)) {
                studentLagging = studentLagging+s.getFirstName()+" "+s.getLastName()+", ";
            }
        }
        logger.error("Двоечники: "+studentLagging.substring(0,studentLagging.length()-2));
        System.out.println("Двоечники: "+studentLagging.substring(0,studentLagging.length()-2));
    }
}

