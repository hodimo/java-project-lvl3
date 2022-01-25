package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    StringSchema schema = new StringSchema();

    @Test
    void blankSchemaTest() {
        Assertions.assertTrue(schema.isValid("string_abcdefg"));
        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));
    }

    @Test
    void requiredTest() {
        schema.required();
        Assertions.assertTrue(schema.isValid("string_abcdefg"));
        Assertions.assertFalse(schema.isValid(""));
        Assertions.assertFalse(schema.isValid(null));
    }

    @Test
    void containsTest() {
        Assertions.assertTrue(schema.contains("str").isValid("string_abcdefg"));
        Assertions.assertFalse(schema.contains("_abce").isValid("string_abcdefg"));
    }

    @Test
    void minLengthTest() {
        Assertions.assertTrue(schema.minLength(0).isValid(""));
        Assertions.assertTrue(schema.minLength(13).isValid("string_abcdefg"));
        Assertions.assertFalse(schema.minLength(15).isValid("string_abcdefg"));
    }
}
