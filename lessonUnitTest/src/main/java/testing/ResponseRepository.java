package testing;

import java.util.List;

public class ResponseRepository {
    public boolean writeResult(List<String> result) {
        System.out.println("Если вы видите этот лог, то тест написан неправильно1");
        return false;
    }

    public void writeError(String s) {
        System.out.println("Если вы видите этот лог, то тест написан неправильно2");
    }
}
