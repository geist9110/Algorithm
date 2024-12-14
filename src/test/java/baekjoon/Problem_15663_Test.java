package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15663_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15663());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3 1\n"
                + "4 4 2", "2\n"
                + "4"),
            Arguments.of("4 2\n"
                + "9 7 9 1", "1 7\n"
                + "1 9\n"
                + "7 1\n"
                + "7 9\n"
                + "9 1\n"
                + "9 7\n"
                + "9 9"),
            Arguments.of("4 4\n"
                + "1 1 1 1", "1 1 1 1"),
            Arguments.of("3 3\n"
                    + "1 2 2",
                "1 2 2\n2 1 2\n2 2 1")
        );
    }
}