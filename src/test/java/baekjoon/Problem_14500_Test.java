package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14500_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14500());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 5\n"
                + "1 2 3 4 5\n"
                + "5 4 3 2 1\n"
                + "2 3 4 5 6\n"
                + "6 5 4 3 2\n"
                + "1 2 1 2 1", "19"),
            Arguments.of("4 5\n"
                + "1 2 3 4 5\n"
                + "1 2 3 4 5\n"
                + "1 2 3 4 5\n"
                + "1 2 3 4 5", "20"),
            Arguments.of("4 10\n"
                + "1 2 1 2 1 2 1 2 1 2\n"
                + "2 1 2 1 2 1 2 1 2 1\n"
                + "1 2 1 2 1 2 1 2 1 2\n"
                + "2 1 2 1 2 1 2 1 2 1", "7")
        );
    }
}