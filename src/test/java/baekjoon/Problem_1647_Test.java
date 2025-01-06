package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1647_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1647());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 12\n"
                + "1 2 3\n"
                + "1 3 2\n"
                + "3 2 1\n"
                + "2 5 2\n"
                + "3 4 4\n"
                + "7 3 6\n"
                + "5 1 5\n"
                + "1 6 2\n"
                + "6 4 1\n"
                + "6 5 3\n"
                + "4 5 3\n"
                + "6 7 4", "8"),
            Arguments.of("2 1\n"
                + "1 2 3", "0")
        );
    }
}