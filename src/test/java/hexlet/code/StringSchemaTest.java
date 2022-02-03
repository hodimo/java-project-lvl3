package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    private final StringSchema schema = new Validator().string();

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
        Assertions.assertFalse(schema.contains("elp").isValid("Hello"));
    }

    @Test
    void minLengthTest() {
        final int trueLength = 13;
        Assertions.assertTrue(schema.minLength(0).isValid(""));
        Assertions.assertTrue(schema.minLength(trueLength).isValid("string_abcdefg"));
        Assertions.assertFalse(schema.minLength(trueLength + 2).isValid("string_abcdefg"));
    }
}
