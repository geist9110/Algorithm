package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17144_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17144());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 8 1\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "188"),
            Arguments.of("7 8 2\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "188"),
            Arguments.of("7 8 3\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "186"),
            Arguments.of("7 8 4\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "178"),
            Arguments.of("7 8 5\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "172"),
            Arguments.of("7 8 20\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "71"),
            Arguments.of("7 8 30\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "52"),
            Arguments.of("7 8 50\n"
                + "0 0 0 0 0 0 0 9\n"
                + "0 0 0 0 3 0 0 8\n"
                + "-1 0 5 0 0 0 22 0\n"
                + "-1 8 0 0 0 0 0 0\n"
                + "0 0 0 0 0 10 43 0\n"
                + "0 0 5 0 15 0 0 0\n"
                + "0 0 40 0 0 0 20 0", "46")
        );
    }
}