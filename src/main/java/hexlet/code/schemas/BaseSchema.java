package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    private final Map<String, Validation> checks = new HashMap<>();

    public final boolean isValid(Object value) {
        for (Map.Entry<String, Validation> validation: checks.entrySet()) {
            if (!validation.getValue().validate(value)) {
                return false;
            }
        }
        return true;
    }

    protected final void addCheck(String validatorName, Validation validation) {
        checks.put(validatorName, validation);
    }

    interface Validation {
        boolean validate(Object value);
    }
}
