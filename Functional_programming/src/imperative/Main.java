package imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Penis> penises = List.of(
                new Penis("Dildo" , 40),
                new Penis("Arne", 50)
        );

        // Imperative approach
        List<Penis> greaterThan40 = new ArrayList<>();

        for (Penis p : penises) {
            if (p.getSize() > 40) greaterThan40.add(p);
        }

        for (Penis p : greaterThan40){
            System.out.println(p);
        }
    }

    static class Penis {
        private final String name;
        private final int size;

        public Penis(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "Penis{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }
}
