package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Validation isNonEmptyString = value -> value != null && !((String) value).isEmpty();
        addCheck("required", isNonEmptyString);
        return this;
    }

    public final StringSchema contains(String substring) {
        Validation isContains = value -> ((String) value).contains(substring);
        addCheck("contains", isContains);
        return this;
    }

    public final StringSchema minLength(int length) {
        Validation isNotLessByLength = value -> ((String) value).length() >= length;
        addCheck("minLength", isNotLessByLength);
        return this;
    }
}
