package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        Validation isMap = value -> value instanceof Map;
        addCheck("required", isMap);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Validation isMapSizeEqualTo = value -> ((Map<Object, Object>) value).size() == size;
        addCheck("sizeof", isMapSizeEqualTo);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Validation isMapFitToShapeByFields = value -> {
            Map<String, Object> checkedMap = (Map<String, Object>) value;
            for (String key: schemas.keySet()) {
                if (!schemas.get(key).isValid(checkedMap.get(key))) {
                    return false;
                }
            }
            return true;
        };
        addCheck("shape", isMapFitToShapeByFields);
        return this;
    }
}
