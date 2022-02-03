package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    private Map<String, Validation> checks;

    public final boolean isValid(Object value) {
        if (checks == null) {
            return true;
        }
        for (Map.Entry<String, Validation> validation: checks.entrySet()) {
            if (!validation.getValue().validate(value)) {
                return false;
            }
        }
        return true;
    }

    protected final void addCheck(String validatorName, Validation validation) {
        if (checks == null) {
            checks = new HashMap<>();
        }
        checks.put(validatorName, validation);
    }

    interface Validation {
        boolean validate(Object value);
    }
}
