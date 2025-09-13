package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_16439_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16439());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 6\n"
                + "1 2 3 4 5 6\n"
                + "6 5 4 3 2 1\n"
                + "3 2 7 9 2 5\n"
                + "4 5 6 3 2 1", "25"),
            Arguments.of("3 5\n"
                + "1 2 3 4 5\n"
                + "5 4 3 2 1\n"
                + "1 2 3 2 1", "13")
        );
    }
}