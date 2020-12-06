package Lesson4;

import java.util.*;

public class MyList {

    public static void main(String[] args) {
        /*-------1----------*/
        ArrayList<Car> list = new ArrayList<Car>();
        Car audi = new Car("A8", 180);
        Car peugeot = new Car("406", 103);
        Car fiat = new Car("Double", 80);
        Car porsche = new Car("Cayenne", 350);
        Car renault = new Car("Kaptur", 116);
        Car volga = new Car("Volga310", 89);
        Car citroen = new Car("C3 Picasso", 110);
        Car mercedes = new Car("Benz", 500);
        Car opel = new Car("Astra", 140);
        Car nissan = new Car("Optima", 200);
        Car chevrolete = new Car("Aveo", 82);
        list.add(audi);
        list.add(peugeot);
        list.add(fiat);
        list.add(porsche);
        list.add(renault);
        list.add(volga);
        list.add(chevrolete);
        list.add(citroen);
        list.add(mercedes);
        list.add(opel);
        list.add(nissan);
        list.remove(volga);
        list.remove(mercedes);
        list.remove(fiat);
        /*-------2----------*/
        list.add(audi);
        list.add(fiat);
        list.add(new Car("A8", 180));
        /*-------3----------*/
        System.out.println(list);
        Collections.sort(list, new CarComparator());
        System.out.println(list);
        System.out.println("------------");

        /*-------4----------*/
        Set<Car> treeSet = new TreeSet<Car>(list);
        /*for (Car cars : list) {
            treeSet.add(cars);
        }*/
        System.out.println(treeSet);
        /*---------5---------------------*/
        int fullPower = 0;
        for (Car car : treeSet) {
            if (car.getName().startsWith("A")) {
                fullPower += car.getPower();
            }
        }
        System.out.println("Машины, название которых начинается на А имеют суммарную мощность: " + fullPower + " л.с.");
        /*--------6-------------*/
        Iterator<Car> iterator = treeSet.iterator();
        int cnt = 0;
        while (iterator.hasNext()) {
            iterator.next();
            cnt++;
            if (cnt == 3) {
                iterator.remove();
                break;
            }
        }
        System.out.println(treeSet);
        /*----------7-------------*/
        List<Bill> billList = new ArrayList<>();
        Bill b1 = new Bill(audi, 400);
        Bill b2 = new Bill(audi, 500);
        Bill b3 = new Bill(audi, 450);
        Bill b4 = new Bill(opel, 120);
        Bill b5 = new Bill(opel, 85);

        billList.add(b1);
        billList.add(b4);
        billList.add(b2);
        billList.add(b3);
        billList.add(b5);
        System.out.println("----------------------------------------");
        System.out.println(billList);
        HashMap<Car, List<Bill>> taxiMap = new HashMap<>();
        for (Bill bill : billList) {
            if (taxiMap.containsKey(bill.getTaxi_name()))
                taxiMap.get(bill.getTaxi_name()).add(bill);
            else {
                taxiMap.put(bill.getTaxi_name(), new ArrayList<Bill>());
                taxiMap.get(bill.getTaxi_name()).add(bill);
            }
        }
        System.out.println(taxiMap);
        /*-----------------------8---------------------*/
        /* получаем суммарный доход по ключу машина*/
        HashMap<Car, Integer> taxiDebit = new HashMap<>();
        for (Map.Entry<Car, List<Bill>> entry : taxiMap.entrySet()) {
            taxiDebit.put(entry.getKey(),sumPrice(entry.getValue()));
        }
        System.out.println("-------new Map------");
        System.out.println(taxiDebit);
    }

     private static Integer sumPrice(List<Bill> lb) {
        Integer result = 0;
        for (Bill bill : lb) {
            result += bill.getPrice();
        }
        return result;
    }

    public static class CarComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            if (o1.getName().length() < o2.getName().length()) {
                return -1;
            } else if (o1.getName().length() > o2.getName().length()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
