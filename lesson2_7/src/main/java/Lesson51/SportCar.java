package Lesson51;

import java.util.List;

public class SportCar extends Mashine {
    private Person owner;

    public SportCar(String model, int place, Person owner) {
        super(model, place);
        this.owner = owner;
    }
}
