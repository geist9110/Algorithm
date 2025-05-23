package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15686_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15686());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 3\n"
                + "0 0 1 0 0\n"
                + "0 0 2 0 1\n"
                + "0 1 2 0 0\n"
                + "0 0 1 0 0\n"
                + "0 0 0 0 2", "5"),
            Arguments.of("5 2\n"
                + "0 2 0 1 0\n"
                + "1 0 1 0 0\n"
                + "0 0 0 0 0\n"
                + "2 0 0 1 1\n"
                + "2 2 0 1 2", "10"),
            Arguments.of("5 1\n"
                + "1 2 0 0 0\n"
                + "1 2 0 0 0\n"
                + "1 2 0 0 0\n"
                + "1 2 0 0 0\n"
                + "1 2 0 0 0", "11"),
            Arguments.of("5 1\n"
                + "1 2 0 2 1\n"
                + "1 2 0 2 1\n"
                + "1 2 0 2 1\n"
                + "1 2 0 2 1\n"
                + "1 2 0 2 1", "32")
        );
    }
}