package Lesson51;

import java.util.*;

public class MashineLenName implements BaseI<Mashine,String> {
        @Override
        public Mashine getMashine(Mashine element) {
            return element;
        }

        @Override
        public String getValue(Mashine element) {
            return element.getModel();
        }

    @Override
    public int sumValue(String u1, int curr) {
        return curr+u1.length();
    }

    @Override
        public boolean isPower(String u1, String u2) {
            return u1.length()>u2.length();
        }

    @Override
    public ArrayList<Mashine> sort(ArrayList<Mashine> lst) {
        ArrayList<Mashine> sortedColl = new ArrayList<>();
        ArrayList<Mashine> currColl = lst;
        Mashine tmp;
        if (lst != null && !lst.isEmpty()) {
            Iterator<Mashine> iterator = lst.iterator();
            while (iterator.hasNext()) {
                tmp = calc(currColl);
                sortedColl.add(tmp);
                currColl.remove(tmp);
            }
        }
        return sortedColl;
    }


}