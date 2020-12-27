package Lesson51;

public class Bus extends Mashine{

    public Bus(String model, int place) {
        super(model, place);
    }

    @Override
    public String toString() {
        return "Bus{"+
                "place=" + getPlace() +
                ", model=" + getModel()+"}";
    }
}
