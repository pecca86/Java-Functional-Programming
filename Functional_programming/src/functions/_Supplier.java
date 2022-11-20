package functions;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionSupplier.get());
    }

    // Classic way
    static String getDBConnectionURL() {
        return "jdcb://locahost:3063/users";
    }

    // Functional
     static Supplier<List<String>> getDBConnectionSupplier = () ->
            List.of("jdcb://locahost:3063/users");
}
