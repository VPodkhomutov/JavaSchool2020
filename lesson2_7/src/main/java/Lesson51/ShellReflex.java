package Lesson51;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.*;

public class ShellReflex {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название класса для получения информации:");
        String s = sc.nextLine();
        getInfo(s);
    }

    public static void getInfo(String s) throws ClassNotFoundException {
        Class classObject = Class.forName("Lesson51."+s);
        System.out.println("----------------------");
        System.out.println("Дерево наследников:");

        System.out.println(classObject.getSimpleName());
        getTree(classObject);
        System.out.println("----------------------");
        System.out.println("Интерфейсы:");
        Class[] interfaces = classObject.getInterfaces();
            System.out.println(Arrays.toString(interfaces));

        Method[] methods = classObject.getMethods();
        System.out.println("----------------------");
        System.out.println("Методы класса:");
        for (Method metod : methods){
            System.out.println("Наименование: "+metod.getName()+", Параметры: "+ Arrays.toString(metod.getParameterTypes())+", результат: "+metod.getReturnType().getSimpleName());
        }

        Field[] fields = classObject.getDeclaredFields();
        System.out.println("----------------------");
        System.out.println("Поля класса:");
        getCurrField(classObject);
    }

    public static void getTree(Class obj) {
        Class parent = obj.getSuperclass();
        System.out.println(parent.getSimpleName());
        if (parent.getSuperclass() != null) {
            getTree(parent);
        }
    }

    public static void getCurrField(Class obj) throws ClassNotFoundException {
        Field[] fields = obj.getDeclaredFields();
        for (Field field : fields){
            if (field.getType().isPrimitive() || Modifier.isFinal(field.getModifiers())) {
                System.out.println(obj.getSimpleName()+", Наименование: " + field.getName() + ", тип: " + field.getType().getSimpleName() + ", приватное: " + Modifier.isPrivate(field.getModifiers()));
            }
            else{
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    System.out.println(obj.getSimpleName()+", Наименование: " + field.getName() + ", тип: Generic, приватное: " + Modifier.isPrivate(field.getModifiers()));
                } else {
                    System.out.println(obj.getSimpleName()+", Наименование: " + field.getName() + ", тип: " + field.getType().getSimpleName() + ", приватное: " + Modifier.isPrivate(field.getModifiers())+", раскрываем данное поле:");
                    getCurrField(Class.forName(field.getType().getName()));

                }
            }
        }
        if (obj.getSuperclass() != null) {
            getCurrField(obj.getSuperclass());
        }
    }
}
