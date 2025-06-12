package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1106_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1106());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("12 2\n"
                + "3 5\n"
                + "1 1", "8"),
            Arguments.of("10 3\n"
                + "3 1\n"
                + "2 2\n"
                + "1 3", "4"),
            Arguments.of("10 10\n"
                + "1 1\n"
                + "2 2\n"
                + "3 3\n"
                + "4 4\n"
                + "5 5\n"
                + "6 6\n"
                + "7 7\n"
                + "8 8\n"
                + "9 9\n"
                + "10 10", "10"),
            Arguments.of("100 6\n"
                + "4 9\n"
                + "9 11\n"
                + "3 4\n"
                + "8 7\n"
                + "1 2\n"
                + "9 8", "45"),
            Arguments.of("13 2\n"
                + "5 6\n"
                + "4 2", "14"),
            Arguments.of("1000 1\n"
                + "100 1", "100000")
        );
    }
}