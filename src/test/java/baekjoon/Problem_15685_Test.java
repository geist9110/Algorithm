package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15685_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15685());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "3 3 0 1\n"
                + "4 2 1 3\n"
                + "4 2 2 1", "4"),
            Arguments.of("4\n"
                + "3 3 0 1\n"
                + "4 2 1 3\n"
                + "4 2 2 1\n"
                + "2 7 3 4", "11"),
            Arguments.of("10\n"
                + "5 5 0 0\n"
                + "5 6 0 0\n"
                + "5 7 0 0\n"
                + "5 8 0 0\n"
                + "5 9 0 0\n"
                + "6 5 0 0\n"
                + "6 6 0 0\n"
                + "6 7 0 0\n"
                + "6 8 0 0\n"
                + "6 9 0 0", "8"),
            Arguments.of("4\n"
                + "50 50 0 10\n"
                + "50 50 1 10\n"
                + "50 50 2 10\n"
                + "50 50 3 10", "1992")
        );
    }
}