package Lesson5;

import java.util.List;

public class GenInterfImpl implements GenericInterface<Person> {

    @Override
    public Person maxximum(List<Person> list) {
        Person res = null;
        int cnt = 0;
        for (Person tmp : list) {
            if (tmp.getName().length() > cnt) {
                res = tmp;
                cnt = tmp.getName().length();
            }
        }
        return res;
    }
}
