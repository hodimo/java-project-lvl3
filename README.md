### Hexlet tests and linter status:
[![Actions Status](https://github.com/proydemte/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/proydemte/java-project-lvl3/actions)
[![CI](https://github.com/proydemte/java-project-lvl3/workflows/CI/badge.svg)](https://github.com/proydemte/java-project-lvl3/actions/workflows/CI.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/52edeac637dca62a472e/maintainability)](https://codeclimate.com/github/proydemte/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/52edeac637dca62a472e/test_coverage)](https://codeclimate.com/github/proydemte/java-project-lvl3/test_coverage)

 Валидатор данных – библиотека, которая предоставляет возможность валидации различных значений (на данный момент реализованы проверки для значений классов String, Integer и Map).

Пример использования:

````
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
````