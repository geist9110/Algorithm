package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1600_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1600());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1\n"
                + "4 4\n"
                + "0 0 0 0\n"
                + "1 0 0 0\n"
                + "0 0 1 0\n"
                + "0 1 0 0", "4"),
            Arguments.of("2\n"
                + "5 2\n"
                + "0 0 1 1 0\n"
                + "0 0 1 1 0", "-1"),
            Arguments.of(
                "2\n"
                    + "8 12\n"
                    + "0 0 0 0 0 0 0 0\n"
                    + "0 1 1 1 1 1 1 0\n"
                    + "0 1 1 1 1 1 1 0\n"
                    + "0 1 1 0 0 0 0 0\n"
                    + "0 1 1 0 1 1 1 1\n"
                    + "0 1 1 0 1 1 1 1\n"
                    + "0 1 1 0 0 0 0 0\n"
                    + "0 1 1 0 1 1 1 0\n"
                    + "0 1 1 1 1 1 1 0\n"
                    + "1 1 0 0 0 0 1 1\n"
                    + "1 1 1 1 1 1 1 1\n"
                    + "1 1 1 0 1 1 0 0", "14"),
            Arguments.of(
                "1\n"
                    + "7 8\n"
                    + "0 0 0 0 0 0 0\n"
                    + "1 1 1 1 1 1 0\n"
                    + "1 1 1 1 1 1 0\n"
                    + "0 0 0 1 1 1 0\n"
                    + "0 1 1 1 0 0 0\n"
                    + "0 1 1 1 1 1 1\n"
                    + "0 1 1 1 1 1 1\n"
                    + "0 0 0 0 0 0 0\n", "25"),
            Arguments.of(
                "30\n"
                    + "7 10\n"
                    + "0 1 1 1 0 1 1\n"
                    + "1 1 0 1 1 1 0\n"
                    + "1 1 1 1 1 1 1\n"
                    + "1 1 1 1 1 0 1\n"
                    + "1 1 1 0 1 1 1\n"
                    + "1 0 1 1 1 1 1\n"
                    + "1 1 1 1 1 1 1\n"
                    + "1 1 0 1 1 1 1\n"
                    + "1 1 1 1 0 1 1\n"
                    + "1 1 1 1 1 1 0", "9"),
            Arguments.of(
                "2\n"
                    + "2 6\n"
                    + "0 1\n"
                    + "1 1\n"
                    + "1 0\n"
                    + "1 1\n"
                    + "0 1\n"
                    + "0 0", "4"),
            Arguments.of(
                "3\n"
                + "9 3\n"
                + "0 1 0 1 1 1 1 0 0\n"
                + "0 1 0 0 0 1 0 0 0\n"
                + "0 0 0 1 1 1 0 1 0\n", "6"
            )
        );
    }
}