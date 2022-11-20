package Declerative;

import imperative.Main;

import java.util.List;
import java.util.stream.Collectors;
/*
    FUNCTION RULES:
    - No state
    - Pure
    - No side effects
    - Higher order functions
        * Function takes function as param
        * Function returns a function as result
 */

public class App {
    public static void main(String[] args) {
        List<Penis> penises = List.of(
                new Penis("Dildo" , 40),
                new Penis("Arne", 50)
        );

        penises.stream()
                .filter(penis -> penis.size > 40)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }


    public static class Penis {
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
