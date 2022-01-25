package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {
    MapSchema schema = new MapSchema();
    Map<Object, Object> map = new HashMap<>(Map.of("key1", true));

    @Test
    public void blankSchemaTest() {
        Assertions.assertTrue(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(map));
    }

    @Test
    public void requiredTest() {
        schema.required();
        Assertions.assertTrue(schema.isValid(map));
        Assertions.assertFalse(schema.isValid(null));
    }

    @Test
    public void sizeOfTest() {
        schema.sizeOf(1);
        Assertions.assertTrue(schema.isValid(map));

        map.put("key2", 21);
        Assertions.assertFalse(schema.isValid(map));
    }
}
