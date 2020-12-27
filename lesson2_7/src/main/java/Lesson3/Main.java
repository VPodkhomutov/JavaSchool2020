package Lesson3;

public class Main {
    public static void main(String[] args) {
        LList myList = new LList();
        myList.add(1);
        myList.add(2);
        myList.add(35);
        myList.add("Slava");
        System.out.println(myList);
        String res="";
        Object resList = myList.get(2);
        if (resList instanceof Integer) {
            res = Integer.toString((Integer) resList ); //можно конечно забить на приведение, т.к. в данном случае отобразится по-умолчанию
        } else if (resList instanceof String) {
            res = (String) resList;                     //можно конечно забить на приведение, т.к. в данном случае отобразится по-умолчанию
        } else {res = "Тип значения объекта не определен";}  //надо переопределить метод toString у данного объекта, чтобы вывести результат корректно
        System.out.println(res);
    }
}
