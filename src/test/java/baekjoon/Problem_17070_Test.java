package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17070_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17070());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "0 0 0\n"
                + "0 0 0\n"
                + "0 0 0", "1"),
            Arguments.of("4\n"
                + "0 0 0 0\n"
                + "0 0 0 0\n"
                + "0 0 0 0\n"
                + "0 0 0 0", "3"),
            Arguments.of("5\n"
                + "0 0 1 0 0\n"
                + "0 0 0 0 0\n"
                + "0 0 0 0 0\n"
                + "0 0 0 0 0\n"
                + "0 0 0 0 0", "0"),
            Arguments.of("6\n"
                + "0 0 0 0 0 0\n"
                + "0 1 0 0 0 0\n"
                + "0 0 0 0 0 0\n"
                + "0 0 0 0 0 0\n"
                + "0 0 0 0 0 0\n"
                + "0 0 0 0 0 0", "13")
        );
    }
}