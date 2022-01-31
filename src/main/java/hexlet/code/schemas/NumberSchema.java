package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        super.args = new Object[1];
        super.validation = args -> args[0] instanceof Integer;
        return this;
    }

    public NumberSchema positive() {
        super.args = new Object[1];
        super.validation = args -> args[0] == null || (args[0] instanceof Integer && (Integer) args[0] > 0);
        return this;
    }

    public NumberSchema range(Number n1, Number n2) {
        super.args = new Object[3];
        args[0] = n1;
        args[1] = n2;
        super.validation = args -> {
            Integer lowest;
            Integer highest;
            Integer value;
            try {
                lowest = (Integer) args[0];
                highest = (Integer) args[1];
                value = (Integer) args[2];
            } catch (ClassCastException e) {
                return false;
            }
            return value >= lowest && value <= highest;
        };
        return this;
    }
}
