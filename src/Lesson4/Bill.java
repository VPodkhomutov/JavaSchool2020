package Lesson4;

import java.util.Objects;

public class Bill implements Comparable {
    private Car taxi_name;
    private int price;

    public Car getTaxi_name() {
        return taxi_name;
    }

    public void setTaxi_name(Car taxi_name) {
        this.taxi_name = taxi_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bill(Car taxi_name, int price) {
        this.taxi_name = taxi_name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "taxi_name=" + taxi_name +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return price == bill.price &&
                taxi_name.equals(bill.taxi_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxi_name, price);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
