package Lesson51;

import lesson6.MyException;

public class Mashine {
    private String model;
    private int place;

    public Mashine(String model, int place) {
        try {
            if (place<1) {
                throw  new MyException("Исключение по количеству мест", 100, "количество мест должно быть больше 0");
            }
        } catch (MyException e) {
            System.out.println("Checked! Code: "+e.getCode()+", Description: "+ e.getDescription()+", Message: "+ e.getMessage());
            e.printStackTrace();
        }
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
