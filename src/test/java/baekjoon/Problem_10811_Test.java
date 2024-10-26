package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10811_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10811());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 4\n1 2\n3 4\n1 4\n2 2", "3 4 1 2 5"),
            Arguments.of("1 1\n1 1", "1"),
            Arguments.of("5 1\n1 5", "5 4 3 2 1"),
            Arguments.of("5 1\n3 3", "1 2 3 4 5"),
            Arguments.of("4 1\n1 4", "4 3 2 1")
        );
    }
}