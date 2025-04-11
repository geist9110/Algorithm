package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2468_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2468());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n"
                + "6 8 2 6 2\n"
                + "3 2 3 4 6\n"
                + "6 7 3 3 2\n"
                + "7 2 5 3 6\n"
                + "8 9 5 2 7", "5"),
            Arguments.of("7\n"
                + "9 9 9 9 9 9 9\n"
                + "9 2 1 2 1 2 9\n"
                + "9 1 8 7 8 1 9\n"
                + "9 2 7 9 7 2 9\n"
                + "9 1 8 7 8 1 9\n"
                + "9 2 1 2 1 2 9\n"
                + "9 9 9 9 9 9 9", "6"),
            Arguments.of("3\n"
                + "1 1 1\n"
                + "1 1 1\n"
                + "1 1 1", "1")
        );
    }
}