package combinator;

import java.time.LocalDate;

import static combinator.CustomerCombinatorValidator.*;

public class MainApp {

    static CustomerCombinatorValidator customerCombinatorValidator;

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Pekka",
                "p@p.com",
                "12300045",
                LocalDate.of(1986, 7, 28)
        );

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();

        System.out.println("Customer1 valid?: " + customerValidatorService.isValid(customer)); // true

        // Creating a customer with invalid email and phone,
        // we get a false but do not know where the problem was...
        Customer cust2 = new Customer(
                "Pekka",
                "pp@.com",
                "1234",
                LocalDate.of(1986, 7, 28)
        );
        System.out.println("Customer2 valid?: " + customerValidatorService.isValid(cust2));
        
        // COMBINATOR PATTERN
        // CustomerCombinatorValidator is imported as a
        // STATIC IMPORT!
        // ValidationResult is an Enum inside our CustomerCombinatorValidator class

        ValidationResult result = CustomerCombinatorValidator.isEmailValid()
                .and(CustomerCombinatorValidator.isPhoneNumberValid())
                .and(CustomerCombinatorValidator.isAdult())
                .apply(customer);

        System.out.println(result);
        if (result != CustomerCombinatorValidator.ValidationResult.SUCCESS ) {
            System.out.println("Invalid data entered!");
        }

    }
}
