package configurationValidator;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static configurationValidator.ModelCombinatorValidator.ModelValidationResult.*;

public interface ModelCombinatorValidator extends Function<DemoClass, ModelCombinatorValidator.ModelValidationResult> {
    List<ModelValidationResult> results = new ArrayList<>();
    enum ModelValidationResult {
        IS_CONFIGURED,
        MISSING_CTA_LINK,
        MISSING_CTA_LABEL,
        MISSING_TEXT_VALUE,
        MISSING_HEADING,
        MISSING_MESSAGE,
        MISCONFIGURED_STEP_NUMBER,
        NOT_ENABLED;
    }

    private static ModelCombinatorValidator isDemoClassHeadingConfigured() {
        return validatable -> validatable.getHeading() != null ? IS_CONFIGURED : MISSING_HEADING;
    }

    private static ModelCombinatorValidator isDemoClassMessageConfigured() {
        return validatable -> validatable.getMessage() != null ? IS_CONFIGURED : MISSING_MESSAGE;
    }

    private static ModelCombinatorValidator isEnabled() {
        return validatable -> validatable.isEnabled() ? IS_CONFIGURED : NOT_ENABLED;
    }

    static List<ModelCombinatorValidator> getValidators() {
        return List.of(
                isDemoClassHeadingConfigured(),
                isDemoClassMessageConfigured(),
                isEnabled()
        );
    }

    default ModelCombinatorValidator and (ModelCombinatorValidator next) {
        return validatable -> {
            ModelValidationResult result = this.apply(validatable);
            return result.equals(IS_CONFIGURED) ? next.apply(validatable) : result;
        };
    }
}
