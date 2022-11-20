package functions;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer frank = new Customer("Frank", "20032030");
        greet(frank);

        greetConsumer.accept(frank);

        greetAndBonus.accept(frank, false);
        greetAndBonus.accept(frank, true);

    }


    // Functional way, a Consumer is a void function
    static Consumer<Customer> greetConsumer = customer ->
            System.out.println("Howdy, " + customer.name + " - " + customer.phone);

    // Consumer that takes two args
    static BiConsumer<Customer, Boolean> greetAndBonus = (customer, sayHomo) ->
            System.out.println("Hi homo-" + customer.name +
                    (sayHomo ? "! I think you are a homo!" : ""));


    // Classic way
    static void greet(Customer customer) {
        System.out.println("Hi " + customer.name + " - " + customer.phone + ", you fuck face!");;
    }

    static class Customer {
        private final String name;
        private final String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
