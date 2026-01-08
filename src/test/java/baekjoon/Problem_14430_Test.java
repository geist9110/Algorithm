package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_14430_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14430());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "5 4\n0 1 0 0\n0 0 1 0\n1 1 0 0\n1 0 1 0\n1 1 0 0", "4"),
                Arguments.of("3 3\n1 0 1\n0 0 1\n0 0 1", "4"));
    }

}
