package optinals;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Person pekka = new Person("Pekka", null);

        // Handling nulls using optional
        String pekkaMail = pekka.getEmail()
                .map(String::toUpperCase)
                .orElse("No email for this user");
        System.out.println(pekkaMail);


        // Same logic
        if (pekka.getEmail().isPresent()) {
            System.out.println(pekka.getEmail().get());
        } else {
            System.out.println("No email");
        }
    }


}

    class Person {
        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        // Wrap into optional, since value can be null
        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
