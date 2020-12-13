package Lesson51;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("lada kalina",4);
        Track track = new Track("Man",2);
        Bus bus = new Bus("Ikarus",51);
        ArrayList<Mashine> mashineList = new ArrayList<Mashine>();
        mashineList.add(sedan);
        mashineList.add(track);
        mashineList.add(bus);
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
}
