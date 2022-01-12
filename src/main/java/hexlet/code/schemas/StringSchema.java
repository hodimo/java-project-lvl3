package hexlet.code.schemas;

public class StringSchema {

    private String currentValidation = "none";
    private String valueForContains = null;
    private int valueForMinLength = Integer.MAX_VALUE;

    public boolean isValid(String string) {
        return switch (currentValidation) {
            case "none" -> true;
            case "required" -> string != null && !string.isEmpty();
            case "contains" -> string.contains(valueForContains);
            case "minLength" -> string.length() >= valueForMinLength;
            default -> throw new IllegalStateException("Unexpected value: " + currentValidation);
        };
    }

    public void required() {
        currentValidation = "required";
    }

    public StringSchema contains(String substring) {
        currentValidation = "contains";
        valueForContains = substring;
        return this;
    }

    public StringSchema minLength(int length) {
        currentValidation = "minLength";
        valueForMinLength = length;
        return this;
    }
}
