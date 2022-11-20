package functions;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        //System.out.println(isHomo("Knut"));
        //System.out.println(isHomoFunc.test("Timo"));

        System.out.println(
            isHomoFunc.and(containsLetterI).test("Timo")
        ); // true

        System.out.println(
            isHomoFunc.and(containsLetterI).test("Kniv-Sixten")
        ); // false

        // OR with same logic
        System.out.println(
            isHomoFunc.or(containsLetterI).test("Kniv-Sixten")
        ); // should now be true

    }

    // Classic way
    static boolean isHomo(String name) {
        return name.startsWith("Ti") && name.length() > 3;
    }

    // Functional
    static Predicate<String> isHomoFunc = name ->
            name.startsWith("Ti") && name.length() > 3;

    static Predicate<String> containsLetterI = name ->
            name.contains("i");
}
