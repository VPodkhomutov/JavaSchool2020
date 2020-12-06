package Lesson5;

import java.util.Random;

public class ClientShopper extends ClientIdentifiable {
    private String name;
    private int id;

    public ClientShopper( String name1, int id) {
        this.name = name1;
        this.id = id;
    }

    public int spent(){
        Random r = new Random();
        return r.nextInt(10)+1;
    }

    @Override
    public String toString() {
        return "ClientShopper{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
