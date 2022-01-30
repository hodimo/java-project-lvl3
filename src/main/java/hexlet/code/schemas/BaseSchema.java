package hexlet.code.schemas;

import java.util.List;

public abstract class BaseSchema {
    Validation validation;
    protected Object[] args;

    public boolean isValid(Object value) {
        if (args == null) {
            return true;
        }
        int freeElem = args.length - 1;
        args[freeElem] = value;
        return validation.validate(args);
    }

    protected static boolean isNull(Object[] args) {
        for (Object arg: args) {
            if (arg == null) {
                return true;
            }
        }
        return false;
    }

    interface Validation {
        boolean validate(Object[] args);
    }
}
