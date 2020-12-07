package Lesson51;

public class Sedan extends Mashine {
    public Sedan(String model, int place) {
        super(model, place);
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "place=" + getPlace() +
                ", model=" + getModel()+
                '}';
    }
}
