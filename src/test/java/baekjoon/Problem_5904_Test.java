package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5904_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5904());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1", "m"),
            Arguments.of("2", "o"),
            Arguments.of("3", "o"),
            Arguments.of("4", "m"),
            Arguments.of("5", "o"),
            Arguments.of("6", "o"),
            Arguments.of("7", "o"),
            Arguments.of("8", "m"),
            Arguments.of("9", "o"),
            Arguments.of("10", "o"),
            Arguments.of("11", "m"),
            Arguments.of("12", "o"),
            Arguments.of("13", "o"),
            Arguments.of("14", "o"),
            Arguments.of("15", "o"),
            Arguments.of("16", "m"),
            Arguments.of("17", "o"),
            Arguments.of("18", "o"),
            Arguments.of("19", "m"),
            Arguments.of("20", "o"),
            Arguments.of("21", "o"),
            Arguments.of("22", "o"),
            Arguments.of("23", "m"),
            Arguments.of("24", "o"),
            Arguments.of("25", "o")
        );
    }
}