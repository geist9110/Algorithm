package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1449_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1449());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 2\n"
                + "1 2 100 101", "2"),
            Arguments.of("5 3\n"
                + "10 11 12 13 14", "2"),
            Arguments.of("4 3\n"
                + "1 2 3 4", "2"),
            Arguments.of("3 1\n"
                + "3 2 1", "3")
        );
    }
}