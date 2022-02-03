package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        Validation isNumber = value -> value instanceof Number;
        addCheck("required", isNumber);
        return this;
    }

    public NumberSchema positive() {
        Validation isPositiveNumber = value -> value == null || (value instanceof Integer && ((Integer) value) > 0);
        addCheck("positive", isPositiveNumber);
        return this;
    }

    public NumberSchema range(Integer n1, Integer n2) {
        Validation isNumberInRange = value -> value instanceof Integer
                && (Integer) value >= n1 && (Integer) value <= n2;
        addCheck("range", isNumberInRange);
        return this;
    }
}
