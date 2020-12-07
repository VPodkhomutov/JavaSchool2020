package Lesson51;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("lada kalina",4);
        Track track = new Track("Man",2);
        Bus bus = new Bus("Ikarus",51);
        List<Mashine> mashineList = Arrays.asList(sedan,track, bus);
        //print(new MashinePower(), mashineList);
        System.out.print("Машина с максимальным количеством мест= ");
        System.out.println(new MashinePower().calc(mashineList));
        System.out.print("Средний элемент в коллекции машин= ");
        System.out.println(new MashinePower().middle(mashineList));
        System.out.print("Среднее количество мест в машинах= ");
        System.out.println(new MashineAvg().avgMashine(mashineList));
        System.out.print("Машина с самым длинным названием= ");
        System.out.println(new MashineLenName().calc(mashineList));

    }

    public static void print(MashinePower mashine, List list) {
        System.out.println(mashine.calc(list));
    }
}
