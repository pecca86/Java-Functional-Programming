package optinals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object val = Optional.ofNullable(null)
                .orElseGet(() -> "DEFAULT");

        Object val2 = Optional.ofNullable("homo")
                .orElseGet(() -> "DEFAULT");

//        Object val3 = Optional.ofNullable(null)
//                        .orElseThrow(() -> new IllegalArgumentException("ileeeeeegal!"));

        // Uses a consumer
        Optional.ofNullable("i love to ")
                        .ifPresent( value -> {
                            System.out.println(value + "cum.org(asm)");
                        });

        // Consumer +
        Optional.ofNullable(null)
                        .ifPresentOrElse(name -> System.out.println(name + " e kova!"),
                                () -> {
                                    System.out.println("Cannot tell if kova or not...");
                                });


        System.out.println(val);
        System.out.println(val2);
        //System.out.println(val3);

        // EXAMPLE
        Optional<String> sayHello = Optional.ofNullable(null);
        String helloOr = sayHello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // Extra computaion
                    return "world";
                });
        System.out.println(helloOr);
    }
}
