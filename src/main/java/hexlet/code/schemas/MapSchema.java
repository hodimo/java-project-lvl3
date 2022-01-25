package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public void required() {
        super.args = new Object[1];
        super.validation = args -> args[0] instanceof Map;
    }

    public void sizeOf(int size) {
        super.args = new Object[2];
        args[0] = size;
        super.validation = args ->  ((Map<Object, Object>) args[1]).size() == ((int) args[0]);
    }
}
