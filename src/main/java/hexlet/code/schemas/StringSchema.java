package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public void required() {
        super.args = new Object[1];
        super.validation = args -> args[0] != null && !((String) args[0]).isEmpty();
    }

    public StringSchema contains(String substring) {
        super.args = new Object[2];
        args[0] = substring;
        super.validation = args -> ((String) args[1]).contains((String) args[0]);
        return this;
    }

    public StringSchema minLength(int length) {
        super.args = new Object[2];
        args[0] = length;
        super.validation = args -> ((String) args[1]).length() >= ((Integer) args[0]);
        return this;
    }
}
