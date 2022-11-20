package functions;

import java.util.function.Function;

public class _UtilFunctions {

    public static void main(String[] args) {
        // Classic way
        int i = increment(0);
        System.out.println(i);

        // Use the functional function
        int incMe = incByOneFunc.apply(1);

        // Chaining two functions
        int mult = multiplyBy10.apply(incMe);
        System.out.println(mult);

        Function<Integer, Integer> addThenMult =
                incByOneFunc.andThen(multiplyBy10);
        int result = addThenMult.apply(10);
        System.out.println(result);
    }

    // Functional way of writing the same method as increment()
    // First <TYPE, TYPE> is the input type, second output type
    static Function<Integer, Integer> incByOneFunc =
            number -> number++;

    static Function<Integer, Integer> multiplyBy10 =
            number -> number * 10;


    static int increment(int number) {
        return number + 1;
    }

}
