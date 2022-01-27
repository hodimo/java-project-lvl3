package hexlet.code.schemas;

import java.util.ArrayList;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        super.args = new Object[1];
        Validation validation = args -> {
            if (!isNull(args)) {
                return false;
            }
            return !((String) args[0]).isEmpty();
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    public StringSchema contains(String substring) {
        super.args = new Object[2];
        args[0] = substring;
        Validation validation = args -> {
            if (isNull(args)) {
                return false;
            }
            return ((String) args[1]).contains((String) args[0]);
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    public StringSchema minLength(int length) {
        super.args = new Object[2];
        args[0] = length;
        Validation validation = args -> {
            if (isNull(args)) {
                return false;
            }
            return ((String) args[1]).length() >= ((Integer) args[0]);
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }
}
