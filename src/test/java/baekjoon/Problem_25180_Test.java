package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_25180_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25180());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "1"),
                Arguments.of("3", "1"),
                Arguments.of("4", "1"),
                Arguments.of("5", "1"),
                Arguments.of("6", "1"),
                Arguments.of("7", "1"),
                Arguments.of("8", "1"),
                Arguments.of("9", "1"),
                Arguments.of("10", "2"),
                Arguments.of("11", "3"),
                Arguments.of("12", "2"),
                Arguments.of("13", "3"),
                Arguments.of("14", "2"),
                Arguments.of("15", "3"),
                Arguments.of("16", "2"),
                Arguments.of("17", "3"),
                Arguments.of("18", "2"),
                Arguments.of("19", "3"),
                Arguments.of("34", "4"),
                Arguments.of("27", "3"));
    }
}
