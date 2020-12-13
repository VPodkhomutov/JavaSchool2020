package Lesson51;

public class Mashine {
    private String model;
    private int place;

    public Mashine(String model, int place) {
        this.model = model;
        this.place = place;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Mashine{" +
                "model='" + model + '\'' +
                ", place=" + place +
                '}';
    }
}
