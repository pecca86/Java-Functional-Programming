package functions;

import java.util.function.BiFunction;

// Bifunction takes two inputs
public class _BiFunction {

    public static void main(String[] args) {
        System.out.println(incByOneAndMultiply(2, 10));

        // Functional
        System.out.println(biTesting.apply(2, 10));
    }

    // <input1, input2, result> type
    static BiFunction<Integer, Integer, Integer> biTesting =
            (numInc, numMult) -> (numInc+1) * numMult;

    static int incByOneAndMultiply(int num, int multby) {
        return (num+1) * multby;
    }
}
