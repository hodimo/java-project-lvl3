package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public void required() {
        super.args = new Object[1];
        super.validation = (args) -> args[0] instanceof Number;
    }

    public NumberSchema positive() {
        super.args = new Object[1];
        super.validation = (args) -> ((Number) args[0]).doubleValue() > 0;
        return this;
    }

    public NumberSchema range(Number n1, Number n2) {
        super.args = new Object[3];
        args[0] = n1;
        args[1] = n2;
        super.validation = (args) -> {
            Number value = (Number) args[2];
            Number lowest = (Number) args[0];
            Number highest = (Number) args[1];
            return value.doubleValue() >= lowest.doubleValue()
                    && value.doubleValue() <= highest.doubleValue();
        };
        return this;
    }
}
