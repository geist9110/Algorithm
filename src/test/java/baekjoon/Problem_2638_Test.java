package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2638_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2638());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("8 9\n"
                + "0 0 0 0 0 0 0 0 0\n"
                + "0 0 0 1 1 0 0 0 0\n"
                + "0 0 0 1 1 0 1 1 0\n"
                + "0 0 1 1 1 1 1 1 0\n"
                + "0 0 1 1 1 1 1 0 0\n"
                + "0 0 1 1 0 1 1 0 0\n"
                + "0 0 0 0 0 0 0 0 0\n"
                + "0 0 0 0 0 0 0 0 0", "4"),
            Arguments.of("8 9\n"
                + "0 0 0 0 0 0 0 0 0\n"
                + "0 0 0 0 0 0 0 0 0\n"
                + "0 1 1 0 0 0 1 1 0\n"
                + "0 1 0 1 1 1 0 1 0\n"
                + "0 1 0 0 1 0 0 1 0\n"
                + "0 1 0 1 1 1 0 1 0\n"
                + "0 1 1 0 0 0 1 1 0\n"
                + "0 0 0 0 0 0 0 0 0", "3")
        );
    }
}