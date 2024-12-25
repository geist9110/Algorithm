package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14502_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14502());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 7\n"
                + "2 0 0 0 1 1 0\n"
                + "0 0 1 0 1 2 0\n"
                + "0 1 1 0 1 0 0\n"
                + "0 1 0 0 0 0 0\n"
                + "0 0 0 0 0 1 1\n"
                + "0 1 0 0 0 0 0\n"
                + "0 1 0 0 0 0 0", "27"),
            Arguments.of("4 6\n"
                + "0 0 0 0 0 0\n"
                + "1 0 0 0 0 2\n"
                + "1 1 1 0 0 2\n"
                + "0 0 0 0 0 2", "9"),
            Arguments.of("8 8\n"
                + "2 0 0 0 0 0 0 2\n"
                + "2 0 0 0 0 0 0 2\n"
                + "2 0 0 0 0 0 0 2\n"
                + "2 0 0 0 0 0 0 2\n"
                + "2 0 0 0 0 0 0 2\n"
                + "0 0 0 0 0 0 0 0\n"
                + "0 0 0 0 0 0 0 0\n"
                + "0 0 0 0 0 0 0 0", "3")
        );
    }
}