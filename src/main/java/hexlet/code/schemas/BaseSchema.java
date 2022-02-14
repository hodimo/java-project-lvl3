package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> checks = new HashMap<>();

    public final boolean isValid(Object value) {
        if (!checks.containsKey("required")) {
            if (value == null) {
                return true;
            }
        } else if (!checks.get("required").test(value)) {
            return false;
        }
        for (Map.Entry<String, Predicate<Object>> validation: checks.entrySet()) {
            if (!validation.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }

    protected final void addCheck(String validatorName, Predicate<Object> validation) {
        checks.put(validatorName, validation);
    }
}
