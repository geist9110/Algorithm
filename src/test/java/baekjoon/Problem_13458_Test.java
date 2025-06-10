package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_13458_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_13458());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1\n"
                + "1\n"
                + "1 1", "1"),
            Arguments.of("3\n"
                + "3 4 5\n"
                + "2 2", "7"),
            Arguments.of("5\n"
                + "1000000 1000000 1000000 1000000 1000000\n"
                + "5 7", "714290"),
            Arguments.of("5\n"
                + "10 9 10 9 10\n"
                + "7 20", "10"),
            Arguments.of("5\n"
                + "10 9 10 9 10\n"
                + "7 2", "13"),
            Arguments.of("3\n1 1 1\n3 1", "3")
        );
    }
}