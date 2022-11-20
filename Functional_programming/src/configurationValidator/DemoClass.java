package configurationValidator;

import java.util.List;
import java.util.stream.Collectors;

@DemoConfig
public class DemoClass implements Configurable {
    private String heading;
    private String message;
    @DemoElement(value = true)
    private boolean enabled;

    public DemoClass() {
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isConfigured() {
        return false;
    }

    @Override
    public List<String> getWarnings() {
        List<String> warnings = ModelCombinatorValidator.getValidators()
                .stream()
                .map(f -> f.apply(this).toString())
                .collect(Collectors.toList());

        return warnings;
    }
}
