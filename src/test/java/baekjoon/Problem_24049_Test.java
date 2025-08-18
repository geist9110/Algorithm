package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_24049_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24049());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4 2\n"
                    + "1 0 1 0\n"
                    + "0 1", "1"
            ),
            Arguments.of(
                "3 3\n"
                    + "1 0 1\n"
                    + "1 0 1", "0"
            ),
            Arguments.of("1 1\n"
                + "1\n"
                + "1", "0")
        );
    }
}