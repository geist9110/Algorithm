package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_30805_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_30805());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n"
                + "1 9 7 3\n"
                + "5\n"
                + "1 8 7 5 3", "2\n"
                + "7 3"),
            Arguments.of("5\n"
                + "1 2 8 4 9\n"
                + "5\n"
                + "8 4 1 2 7", "2\n8 4")
        );
    }
}