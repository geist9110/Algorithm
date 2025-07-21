package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_29197_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_29197());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7\n"
                + "1 2\n"
                + "2 4\n"
                + "-2 2\n"
                + "-4 4\n"
                + "-1 0\n"
                + "-3 0\n"
                + "2 -1", "4"),
            Arguments.of("5\n"
                + "1 2\n"
                + "2 4\n"
                + "1 1\n"
                + "3 2\n"
                + "2 2", "3"),
            Arguments.of("2\n"
                + "-10000 -9999\n"
                + "10000 9999", "2")
        );
    }
}