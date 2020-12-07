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
    public boolean isPower(Integer u1, Integer u2) {
        return false;
    }
}
