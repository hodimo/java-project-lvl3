package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        super.args = new Object[1];
        super.validation = args -> args[0] != null && !((String) args[0]).isEmpty();
        return this;
    }

    public StringSchema contains(String substring) {
        super.args = new Object[2];
        args[0] = substring;
        super.validation = args1 -> ((String) args1[1]).contains((String) args1[0]);
        return this;
    }

    public StringSchema minLength(int length) {
        super.args = new Object[2];
        args[0] = length;
        super.validation = args -> ((String) args[1]).length() >= ((Integer) args[0]);
        return this;
    }
}
