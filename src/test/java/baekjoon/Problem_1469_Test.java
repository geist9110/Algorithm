package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1469_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1469());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n1 2 3", "2 3 1 2 1 3"),
                Arguments.of("1\n0", "0 0"),
                Arguments.of("4\n1 2 3 4", "2 3 4 2 1 3 1 4"),
                Arguments.of("5\n1 2 3 4 5", "-1"),
                Arguments.of("2\n2 0", "2 0 0 2"),
                Arguments.of("8\n0 4 13 12 8 5 2 14", "-1"));
    }

}
