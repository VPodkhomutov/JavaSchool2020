package Lesson51;

public class MashineLenName implements BaseI<Mashine,String> {
        @Override
        public Mashine getMashine(Mashine element) {
            return element;
        }

        @Override
        public String getValue(Mashine element) {
            return element.getModel();
        }

    @Override
    public int sumValue(String u1, int curr) {
        return curr+u1.length();
    }

    @Override
        public boolean isPower(String u1, String u2) {
            return u1.length()>u2.length();
        }




    }