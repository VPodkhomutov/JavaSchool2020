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
        public boolean isPower(String u1, String u2) {
            return u1.length()>u2.length();
        }
    }