package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_13398_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_13398());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n-35 12 21 -1 5", "38"),
                Arguments.of("3\n-1 -2 -3", "-1"),
                Arguments.of("1\n-1", "-1"),
                Arguments.of("1\n10", "10"),
                Arguments.of("10\n10 -4 3 1 5 6 -35 12 21 -1", "54"));
    }

}
