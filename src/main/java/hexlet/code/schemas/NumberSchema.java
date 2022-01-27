package hexlet.code.schemas;

import java.util.ArrayList;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        super.args = new Object[1];
        Validation validation = args -> {
            if (!isNull(args)) {
                return false;
            }
            return args[0] instanceof Number;
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    public NumberSchema positive() {
        super.args = new Object[1];
        Validation validation = args -> {
            if (isNull(args)) {
                return false;
            }
            Number number = ((Number) args[0]);
            return number.doubleValue() > 0;
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    public NumberSchema range(Number n1, Number n2) {
        super.args = new Object[3];
        args[0] = n1;
        args[1] = n2;
        Validation validation = args -> {
            if (isNull(args)) {
                return false;
            }
            Number lowest = (Number) args[0];
            Number highest = (Number) args[1];
            Number value = (Number) args[2];
            return value.doubleValue() >= lowest.doubleValue()
                    && value.doubleValue() <= highest.doubleValue();
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }
}
