package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_18124_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_18124());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("13", "14"),
                Arguments.of("1", "0"),
                Arguments.of("2", "1"),
                Arguments.of("3", "3"),
                Arguments.of("4", "3"),
                Arguments.of("8", "7"));
    }
}
