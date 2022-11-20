package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Penis> penises = List.of(
                new Penis("Dildo" , 40),
                new Penis("Arne", 50)
        );

        // Map does transformations to the data
        Set<Integer> sizes = penises.stream()
                .map(penis -> penis.size)
                .collect(Collectors.toSet());

        System.out.println(sizes);

        penises.stream()
                .map(penis -> penis.size)
                .collect(Collectors.toSet())
                .forEach(size -> System.out.println(size));

        // Same as above, last line different syntax
        penises.stream()
                .map(penis -> penis.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("= LEN INCLUDED =");
        // Length of name included
        penises.stream()
                .map(penis -> penis.name)
                .mapToInt(String::length)
                .forEach(System.out::println); // method reference

        // Check if list contains only of penises gta 40
        boolean isGTA40 = penises.stream()
                .allMatch(penis -> penis.size > 40);
        System.out.println(isGTA40);

        boolean atLeastOneOver40 = penises.stream()
                .anyMatch(penis -> penis.size > 40);
        System.out.println(atLeastOneOver40);

        boolean noOneWithUnder40 = penises.stream()
                .noneMatch(penis -> penis.size < 40);
        System.out.println(noOneWithUnder40);

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
