package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_15565_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15565());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("10 3\n1 2 2 2 1 2 1 2 2 1", "6"),
                Arguments.of("1 1\n2", "-1"),
                Arguments.of("4 3\n2 2 2 2", "-1"),
                Arguments.of("8 3\n2 1 2 1 1 2 2 1", "4"),
                Arguments.of("5 1\n1 2 2 2 2", "1"),
                Arguments.of("10 2\n1 2 2 1 2 2 2 2 2 1", "4"));
    }

}
