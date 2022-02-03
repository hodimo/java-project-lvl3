setup:
		gradle wrapper --gradle-version 7.2

build:
		./gradlew clean build

install:
		./gradlew clean install

lint:
		./gradlew check

test:
		./gradlew test

report:
		./gradlew jacocoTestReport

updates-check:
		./gradlew dependencyUpdates

.PHONY: build test
