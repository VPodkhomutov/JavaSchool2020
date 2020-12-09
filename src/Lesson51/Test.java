package Lesson51;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("lada kalina",4);
        Track track = new Track("Man",2);
        Bus bus = new Bus("Ikarus",51);
        //кусок про исключения
        Mashine m1 = new Bus("Mercedes",0); //исключение на конструкторе
        try {
            new Test().exceptionCall();
        } catch (Exception e){
            System.out.println("Внешняя обработка");
            e.printStackTrace();
            System.out.println("Работаем дальше после ошибки");
        }
        //конец исключений
        ArrayList<Mashine> mashineList = new ArrayList<Mashine>();
        mashineList.add(sedan);
        mashineList.add(track);
        mashineList.add(bus);
        System.out.println("");
        System.out.println("");
        System.out.print("Машина с максимальным количеством мест= ");
        System.out.println(new MashinePower().calc(mashineList));
        System.out.print("Средний элемент в коллекции машин= ");
        System.out.println(new MashinePower().middle(mashineList));
        System.out.print("Среднее количество мест в машинах= ");
        System.out.println(new MashineAvg().avgMashine(mashineList));
        System.out.print("Машина с самым длинным названием= ");
        System.out.println(new MashineLenName().calc(mashineList));
        System.out.println("-----------сортировка через Дженерики1----------------");
        System.out.println(mashineList);
        mashineList = new MashineLenName().sort(mashineList);
        System.out.println(mashineList);
        System.out.println("-----------сортировка через анонимный компаратор по количеству мест----------------");
        System.out.println(mashineList);
        Collections.sort(mashineList, new Comparator<Mashine>() {
            public int compare(Mashine o1, Mashine o2) {
                return o1.getPlace()-o2.getPlace();
            }
        });
        System.out.println(mashineList);
        System.out.println("-----------сортировка через lambda выражение(тоже самое что и анонимный компаратор)----------------");
        Collections.sort(mashineList, (o1, o2) -> o1.getPlace()-o2.getPlace());
    }

    public void exceptionCall(){
        List l = new ArrayList();
        l.add(10);
        l.add("Petya");
        try {
            int cnt = (Integer) l.get(1);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getStackTrace());
        }
        catch (Exception e) {
            System.out.println("Unchecked: Ошибка в классе");
            System.out.println(e.getClass());
            throw e;
        }
    }
}
