package Lesson51;

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
}
