package configurationValidator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        DemoClass d = new DemoClass();
        d.setMessage("Pippel");
        d.setHeading("Fitta");

        //activateAnnotations(d);
        functionalAnnotationActivation(d);
        printWarnings(d);

        testFunction();
    }

    private static void testFunction() {
        System.out.println(
                addNum()
                        .andThen(upFun())
                        .apply("KIKKELI")
        );
    }

    private static void printWarnings(DemoClass d) {
        d.getWarnings().stream()
                .filter(result -> !result.equals("IS_CONFIGURED"))
                .forEach(System.out::println);
    }

    private static void activateAnnotations(DemoClass d) throws IllegalAccessException {
        if (d.getClass().isAnnotationPresent(DemoConfig.class)) {
            for (Field field : d.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(DemoElement.class)) {
                    field.setAccessible(true);
                    Object objectValue = field.get(d);
                    if(objectValue instanceof Boolean) {
                        d.setEnabled(field.getAnnotation(DemoElement.class).value());
                    }
                }
            }
        }
    }

    private static void functionalAnnotationActivation(DemoClass d) throws IllegalAccessException {
        if (d.getClass().isAnnotationPresent(DemoConfig.class)) {
            Arrays.stream(d.getClass().getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(DemoElement.class))
                    .filter(result -> {
                        try {
                            result.setAccessible(true);
                            return result.get(d) instanceof Boolean;
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEach(anno -> d.setEnabled(anno.getAnnotation(DemoElement.class).value()));

        }
    }

    public static Function<String, String> upFun() {
        return d -> d.toLowerCase() + "nekke";
    }

    public static Function<String, String> addNum() {
        return d -> d + "101010";
    }
}
