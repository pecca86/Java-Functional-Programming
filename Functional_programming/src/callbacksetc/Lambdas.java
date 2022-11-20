package callbacksetc;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Function<String, String> printName = name -> name.toUpperCase();
        Function<String, String> sameAsAbove = String::toUpperCase;

        // More logic
        Function<String, String> throwsException = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("no name");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> nameAndAge = (name, age) ->
                name.toUpperCase() + age;

        System.out.println(
            nameAndAge.apply("pekka", 10)
        );


    }
}
