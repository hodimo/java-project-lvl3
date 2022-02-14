package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    private final NumberSchema schema = new Validator().number();

    @Test
    void blankSchemaTest() {
        Assertions.assertTrue(schema.isValid(null));
    }

    @Test
    void requiredTest() {
        schema.required();
        final int ten = 10;

        Assertions.assertTrue(schema.isValid(ten));
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid("5"));
    }

    @Test
    void positiveTest() {
        schema.positive();
        final int ten = 10;

        Assertions.assertTrue(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(ten));
        Assertions.assertFalse(schema.isValid(-ten));
    }

    @Test
    void rangeTest() {
        schema.range(5, 10);

        Assertions.assertTrue(schema.isValid(5));
        Assertions.assertTrue(schema.isValid(10));
        Assertions.assertTrue(schema.isValid(7));
        Assertions.assertFalse(schema.isValid(3));
        Assertions.assertFalse(schema.isValid(573));
    }
}

