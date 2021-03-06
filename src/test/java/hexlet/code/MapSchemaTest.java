package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {
    private final MapSchema schema = new Validator().map();
    private final Map<Object, Object> map = new HashMap<>(Map.of("key1", true));

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
    public void sizeofTest() {
        schema.sizeof(1);
        Assertions.assertTrue(schema.isValid(map));

        map.put("key2", 2);
        Assertions.assertFalse(schema.isValid(map));
    }

    @Test
    public void shapeTest() {
        Validator v = new Validator();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required().contains("o"));
        schemas.put("age", v.number().range(18, 100));
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 24);
        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", 15);
        Assertions.assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Tom");
        human4.put("age", 15);
        Assertions.assertFalse(schema.isValid(human4));
    }
}
