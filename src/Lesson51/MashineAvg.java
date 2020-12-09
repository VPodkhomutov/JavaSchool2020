package Lesson51;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MashineAvg implements BaseI<Mashine, Integer> {
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
        return false;
    }

    @Override
    public ArrayList<Mashine> sort(ArrayList<Mashine> collection) {
        return null;
    }

}
