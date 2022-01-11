setup:
		gradle wrapper --gradle-version 7.2

build:
		./gradlew clean build

test:
		./gradlew test

report:
		./gradlew jacocoTestReport

.PHONY: build