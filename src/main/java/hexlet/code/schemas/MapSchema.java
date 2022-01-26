package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        super.args = new Object[1];
        Validation validation = args -> args[0] instanceof Map;
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    public MapSchema sizeof(int size) {
        super.args = new Object[2];
        args[0] = size;
        Validation validation = args ->  {
            if (isNull(args)) {
                return false;
            }
            return ((Map<Object, Object>) args[1]).size() == ((int) args[0]);
        };
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        super.args = new Object[2];
        args[0] = schemas;
        Validation validation = MapSchema::shapeValidation;
        super.validations = new ArrayList<>();
        super.validations.add(validation);
        return this;
    }

    private static boolean shapeValidation(Object[] args) {
        if (isNull(args)) {
            return false;
        }
        if (!(args[1] instanceof Map)) {
            throw new IllegalArgumentException("Is not instance of Map");
        }
        Map<String, BaseSchema> schemas = (Map<String, BaseSchema>) args[0];
        Map<String, Object> uncheckedMap = (Map<String, Object>) args[1];

        for (String key: schemas.keySet()) {
            if (!schemas.get(key).isValid(uncheckedMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}
