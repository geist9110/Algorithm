package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_25192_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25192());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("9\n"
                + "ENTER\n"
                + "pjshwa\n"
                + "chansol\n"
                + "chogahui05\n"
                + "lms0806\n"
                + "pichulia\n"
                + "r4pidstart\n"
                + "swoon\n"
                + "tony9402", "8"),
            Arguments.of("7\n"
                + "ENTER\n"
                + "pjshwa\n"
                + "chansol\n"
                + "chogahui05\n"
                + "ENTER\n"
                + "pjshwa\n"
                + "chansol", "5"),
            Arguments.of("3\n"
                + "ENTER\n"
                + "lms0806\n"
                + "lms0806", "1")
        );
    }
}