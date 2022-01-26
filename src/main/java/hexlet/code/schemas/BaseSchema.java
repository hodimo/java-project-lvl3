package hexlet.code.schemas;

import java.util.List;

public abstract class BaseSchema {
    protected List<Validation> validations;
    protected Object[] args;

    public boolean isValid(Object value) {
        if (args == null) {
            return true;
        }
        int freeElem = args.length - 1;
        args[freeElem] = value;
        for (Validation validation: validations) {
            if (!validation.validate(args)) {
                return false;
            }
        }
        return true;
    }

    protected static boolean checkNull(Object[] args) {
        for (Object arg: args) {
            if (arg == null) {
                return false;
            }
        }
        return true;
    }

    interface Validation {
        boolean validate(Object[] args);
    }
}
