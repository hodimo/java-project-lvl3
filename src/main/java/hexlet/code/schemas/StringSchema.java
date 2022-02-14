package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<Object> isNonEmptyString = value -> value != null && !((String) value).isEmpty();
        addCheck("required", isNonEmptyString);
        return this;
    }

    public final StringSchema contains(String substring) {
        Predicate<Object> isContains = value -> ((String) value).contains(substring);
        addCheck("contains", isContains);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<Object> isNotLessByLength = value -> ((String) value).length() >= length;
        addCheck("minLength", isNotLessByLength);
        return this;
    }
}
