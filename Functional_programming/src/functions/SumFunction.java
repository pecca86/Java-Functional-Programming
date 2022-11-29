package functions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SumFunction {

    public static void main(String[] args) {
        multipleArgs(1,2,3,4,5,6,10);

        System.out.println(summer.apply(10));

        List<Integer> integerList = List.of(10, 20, 30, 40, 50);
        System.out.println(sumMeUp.apply(integerList));

        int result  = sumMeUp.apply(List.of(1,2,3,4,5))
                .intValue();
        System.out.println(result);

        Map<String, List<Integer>> pointsPerMonthMap = new LinkedHashMap<>();
        pointsPerMonthMap.put("Pekka", List.of(10, 10, 10));
        pointsPerMonthMap.put("Kalle", List.of(9, 8, 7));
        pointsPerMonthMap.put("Ville", List.of(1, 2, 3));
        processMap(pointsPerMonthMap);
    }

    public static void processMap(Map<String, List<Integer>> myMap) {
        System.out.println("===== SUMMED POINTS TOTAL PER PLAYER ======");
        myMap.values().stream()
                .forEach(listEntry -> {
                    System.out.println(sumMeUp.apply(listEntry));
                });
    }

    public static int multipleArgs(int ...ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println("next int: " + i);
        }
        return 1;
    }

    public static Function<Integer, Integer> summer =
            num -> num + 10;

    public static Function<List<Integer>, Integer> sumMeUp =
        n -> n.stream()
                .mapToInt(num -> num)
                .sum();
}
