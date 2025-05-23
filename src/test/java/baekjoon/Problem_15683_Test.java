package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15683_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15683());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 6\n"
                + "0 0 0 0 0 0\n"
                + "0 0 0 0 0 0\n"
                + "0 0 1 0 6 0\n"
                + "0 0 0 0 0 0", "20"),
            Arguments.of("6 6\n"
                + "0 0 0 0 0 0\n"
                + "0 2 0 0 0 0\n"
                + "0 0 0 0 6 0\n"
                + "0 6 0 0 2 0\n"
                + "0 0 0 0 0 0\n"
                + "0 0 0 0 0 5", "15"),
            Arguments.of("6 6\n"
                + "1 0 0 0 0 0\n"
                + "0 1 0 0 0 0\n"
                + "0 0 1 0 0 0\n"
                + "0 0 0 1 0 0\n"
                + "0 0 0 0 1 0\n"
                + "0 0 0 0 0 1", "6"),
            Arguments.of("6 6\n"
                + "1 0 0 0 0 0\n"
                + "0 1 0 0 0 0\n"
                + "0 0 1 5 0 0\n"
                + "0 0 5 1 0 0\n"
                + "0 0 0 0 1 0\n"
                + "0 0 0 0 0 1", "2"),
            Arguments.of("1 7\n"
                + "0 1 2 3 4 5 6", "0"),
            Arguments.of("3 7\n"
                + "4 0 0 0 0 0 0\n"
                + "0 0 0 2 0 0 0\n"
                + "0 0 0 0 0 0 4", "0")
        );
    }
}