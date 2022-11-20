package combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;

import combinator.CustomerCombinatorValidator.*;

public interface CustomerCombinatorValidator extends Function<Customer, ValidationResult> {
    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

    // Create validators
    static CustomerCombinatorValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerCombinatorValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().length() == 5 ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerCombinatorValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    // Default method
    // Chain validators
    default CustomerCombinatorValidator and (CustomerCombinatorValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ?
                    other.apply(customer) : result;
        };
    }
}
