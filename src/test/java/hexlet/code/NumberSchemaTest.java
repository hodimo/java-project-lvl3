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
        final int lowBound = 5;
        final int highBound = 10;
        final int inBounds = 7;
        final int belowBounds = 3;
        final int aboveBounds = 573;
        schema.range(lowBound, highBound);

        Assertions.assertTrue(schema.isValid(lowBound));
        Assertions.assertTrue(schema.isValid(highBound));
        Assertions.assertTrue(schema.isValid(inBounds));
        Assertions.assertFalse(schema.isValid(belowBounds));
        Assertions.assertFalse(schema.isValid(aboveBounds));
    }
}

