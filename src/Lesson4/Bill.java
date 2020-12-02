package Lesson4;

import java.util.Objects;

public class Bill implements Comparable {
    Car taxi_name;
    int price;

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
