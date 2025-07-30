package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11505_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11505());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 2 2\n"
                + "1\n"
                + "2\n"
                + "3\n"
                + "4\n"
                + "5\n"
                + "1 3 6\n"
                + "2 2 5\n"
                + "1 5 2\n"
                + "2 3 5", "240\n"
                + "48"),
            Arguments.of("5 2 2\n"
                + "1\n"
                + "2\n"
                + "3\n"
                + "4\n"
                + "5\n"
                + "1 3 0\n"
                + "2 2 5\n"
                + "1 3 6\n"
                + "2 2 5", "0\n"
                + "240"),
            Arguments.of("8 0 1\n"
                + "1\n"
                + "1000000000\n"
                + "1000000000\n"
                + "1\n"
                + "1\n"
                + "1\n"
                + "1000000000\n"
                + "1\n"
                + "2 2 7", "999999664"),
            Arguments.of("7 1 2\n"
                + "921\n"
                + "720\n"
                + "477\n"
                + "589\n"
                + "744\n"
                + "726\n"
                + "813\n"
                + "1 5 959\n"
                + "2 3 4\n"
                + "2 4 7\n", "280953\n"
                + "396522207\n")
        );
    }
}