package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public final NumberSchema required() {
        Predicate<Object> isNumber = value -> value instanceof Number;
        addCheck("required", isNumber);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> isPositiveNumber = value -> (Integer) value > 0;
        addCheck("positive", isPositiveNumber);
        return this;
    }

    public final NumberSchema range(Integer n1, Integer n2) {
        Predicate<Object> isNumberInRange = value -> (Integer) value >= n1 && (Integer) value <= n2;
        addCheck("range", isNumberInRange);
        return this;
    }
}
