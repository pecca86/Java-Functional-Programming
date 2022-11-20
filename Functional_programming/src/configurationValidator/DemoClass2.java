package configurationValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoClass2 implements Configurable {
    private String header;
    private String message;
    private Integer stepNumber;

    public DemoClass2() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    @Override
    public boolean isConfigured() {
        return false;
    }

    @Override
    public List<String> getWarnings() {
        List<String> warnings = new ArrayList<>();

        return warnings;
    }
}
