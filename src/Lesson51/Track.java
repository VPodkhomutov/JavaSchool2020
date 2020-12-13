package Lesson51;

public class Track extends Mashine {
    public Track(String model, int place) {
        super(model, place);
    }

    @Override
    public String toString() {
        return "Track{"+
                "place=" + getPlace() +
                ", model=" + getModel()+"}";
    }
}
