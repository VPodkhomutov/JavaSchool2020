package Lesson4;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String name;
    private int power;

    public Car(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public int compareTo(Car o) {
        if (this.name.equals(o.getName())) {
            return 0;
        } else if (this.name.length() < o.getName().length()) {
            return -1;
        } else {
            return 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return power == car.power &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
