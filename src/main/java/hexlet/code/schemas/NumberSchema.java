package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        super.args = new Object[1];
        super.validation = args -> args[0] instanceof Number;
        return this;
    }

    public NumberSchema positive() {
        super.args = new Object[1];
        super.validation = args -> {
            Number number = ((Number) args[0]);
            return number == null || number.doubleValue() >= 0;
        };
        return this;
    }

    public NumberSchema range(Number n1, Number n2) {
        super.args = new Object[3];
        args[0] = n1;
        args[1] = n2;
        super.validation = args -> {
            Number lowest = (Number) args[0];
            Number highest = (Number) args[1];
            Number value = (Number) args[2];
            return value.doubleValue() >= lowest.doubleValue()
                    && value.doubleValue() <= highest.doubleValue();
        };
        return this;
    }
}
