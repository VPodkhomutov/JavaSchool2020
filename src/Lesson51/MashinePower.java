package Lesson51;

import java.util.Comparator;

public class MashinePower implements BaseI<Mashine,Integer> {
    @Override
    public Mashine getMashine(Mashine element) {
        return element;
    }

    @Override
    public Integer getValue(Mashine element) {
        return element.getPlace();
    }

    @Override
    public int sumValue(Integer u1, int curr) {
        return curr+u1;
    }

    @Override
    public boolean isPower(Integer u1, Integer u2) {
        return u1.compareTo(u2)>0;
    }

    public static class MashinePowerComparator extends MashinePower implements Comparator<Mashine> {
        @Override
        public int compare(Mashine t1, Mashine t2) {
        return super.compare(t1,t2);
        }
    }

}
