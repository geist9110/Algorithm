package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_25516_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25516());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("8 2\n0 1\n0 2\n1 3\n1 4\n2 5\n2 6\n6 7\n1 0 0 1 0 1 0 1", "3"));
    }
}
