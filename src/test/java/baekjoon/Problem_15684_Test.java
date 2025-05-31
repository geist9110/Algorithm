package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15684_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15684());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 0 3", "0"),
            Arguments.of("2 1 3\n"
                + "1 1", "1"),
            Arguments.of("5 5 6\n"
                + "1 1\n"
                + "3 2\n"
                + "2 3\n"
                + "5 1\n"
                + "5 4", "3"),
            Arguments.of("6 5 6\n"
                + "1 1\n"
                + "3 2\n"
                + "1 3\n"
                + "2 5\n"
                + "5 5", "3"),
            Arguments.of("5 8 6\n"
                + "1 1\n"
                + "2 2\n"
                + "3 3\n"
                + "4 4\n"
                + "3 1\n"
                + "4 2\n"
                + "5 3\n"
                + "6 4", "-1"),
            Arguments.of("5 12 6\n"
                + "1 1\n"
                + "1 3\n"
                + "2 2\n"
                + "2 4\n"
                + "3 1\n"
                + "3 3\n"
                + "4 2\n"
                + "4 4\n"
                + "5 1\n"
                + "5 3\n"
                + "6 2\n"
                + "6 4", "-1"),
            Arguments.of("5 6 6\n"
                + "1 1\n"
                + "3 1\n"
                + "5 2\n"
                + "4 3\n"
                + "2 3\n"
                + "1 4", "2"),
            Arguments.of("6 12 6\n"
                + "1 1\n"
                + "3 1\n"
                + "5 1\n"
                + "2 2\n"
                + "4 2\n"
                + "6 2\n"
                + "1 4\n"
                + "3 4\n"
                + "5 4\n"
                + "2 5\n"
                + "4 5\n"
                + "6 5", "0")
        );
    }
}