package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14499_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14499());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 2 0 0 8\n"
                + "0 2\n"
                + "3 4\n"
                + "5 6\n"
                + "7 8\n"
                + "4 4 4 1 3 3 3 2", "0\n"
                + "0\n"
                + "3\n"
                + "0\n"
                + "0\n"
                + "8\n"
                + "6\n"
                + "3"),
            Arguments.of("3 3 1 1 9\n"
                + "1 2 3\n"
                + "4 0 5\n"
                + "6 7 8\n"
                + "1 3 2 2 4 4 1 1 3", "0\n"
                + "0\n"
                + "0\n"
                + "3\n"
                + "0\n"
                + "1\n"
                + "0\n"
                + "6\n"
                + "0"),
            Arguments.of("2 2 0 0 16\n"
                + "0 2\n"
                + "3 4\n"
                + "4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2", "0\n"
                + "0\n"
                + "0\n"
                + "0"),
            Arguments.of("3 3 0 0 16\n"
                + "0 1 2\n"
                + "3 4 5\n"
                + "6 7 8\n"
                + "4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2", "0\n"
                + "0\n"
                + "0\n"
                + "6\n"
                + "0\n"
                + "8\n"
                + "0\n"
                + "2\n"
                + "0\n"
                + "8\n"
                + "0\n"
                + "2\n"
                + "0\n"
                + "8\n"
                + "0\n"
                + "2")
        );
    }
}