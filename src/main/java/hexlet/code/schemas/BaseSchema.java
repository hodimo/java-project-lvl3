package hexlet.code.schemas;

public abstract class BaseSchema {
    protected Validation validation;
    protected Object[] args;

    public boolean isValid(Object value) {
        if (args == null) {
            return true;
        }
        int freeElem = args.length - 1;
        args[freeElem] = value;
        return validation.validate(args);
    }

    interface Validation {
        boolean validate(Object[] args);
    }
}
