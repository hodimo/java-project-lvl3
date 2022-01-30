package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        super.args = new Object[1];
        super.validation = args -> args[0] instanceof Map;
        return this;
    }

    public MapSchema sizeof(int size) {
        super.args = new Object[2];
        args[0] = size;
        super.validation = args -> !isNull(args)
                && ((Map<Object, Object>) args[1]).size() == ((int) args[0]);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        super.args = new Object[2];
        args[0] = schemas;
        super.validation = args -> {
            if (isNull(args)) {
                return false;
            }
            if (!(args[1] instanceof Map)) {
                throw new IllegalArgumentException("Is not instance of Map");
            }
            Map<String, BaseSchema> schemasMap = (Map<String, BaseSchema>) args[0];
            Map<String, Object> checkedMap = (Map<String, Object>) args[1];

            for (String key: schemasMap.keySet()) {
                if (!schemasMap.get(key).isValid(checkedMap.get(key))) {
                    return false;
                }
            }
            return true;
        };
        return this;
    }
}
