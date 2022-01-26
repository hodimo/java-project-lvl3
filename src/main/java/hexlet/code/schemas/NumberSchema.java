package hexlet.code.schemas;

import java.util.ArrayList;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        super.args = new Object[1];
        Validation validation = args -> args[0] instanceof Integer;
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
            Integer number = ((Integer) args[0]);
            return number > 0;
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
            Integer value = (Integer) args[2];
            Integer lowest = (Integer) args[0];
            Integer highest = (Integer) args[1];
            return value >= lowest && value <= highest;
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }
}
