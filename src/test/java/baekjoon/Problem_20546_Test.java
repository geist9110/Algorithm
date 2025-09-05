package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_20546_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20546());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("100\n"
                + "10 20 23 34 55 30 22 19 12 45 23 44 34 38", "BNP"),
            Arguments.of("15\n"
                + "20 20 33 98 15 6 4 1 1 1 2 3 6 14", "TIMING")
        );
    }
}