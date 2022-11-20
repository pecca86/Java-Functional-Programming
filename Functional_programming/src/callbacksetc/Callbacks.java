package callbacksetc;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        // Callback is essentially a function passed in to a function
        hello("John", "Blund", null);

        // with method
        hello("Kuk", null, value -> {
            System.out.println(value + " has no last name!");
        });

        // with runnable method
        hello2("Kuk", null, () -> {
            System.out.println(" has no last name!");
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
