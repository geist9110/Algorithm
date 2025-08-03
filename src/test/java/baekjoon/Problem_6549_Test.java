package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_6549_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_6549());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 2 1 4 5 1 3 3\n"
                + "4 1000 1000 1000 1000\n"
                + "0", "8\n"
                + "4000"),
            Arguments.of("9 4 6 8 5 7 5 9 6 3\n0", "35"),
            Arguments.of("2 1 3\n"
                + "4 1 5 1 4\n"
                + "3 1 5 1\n"
                + "3 0 1 0\n"
                + "0", "3\n5\n5\n1"),
            Arguments.of("5 8 1 3 4 5\n"
                + "0", "9"),
            Arguments.of("9 4 6 8 10 10 9 7 5 3\n"
                + "9 4 6 8 10 0 9 7 5 3\n"
                + "0", "36\n"
                + "18"),
            Arguments.of("9 4 6 8 0 10 9 7 5 3\n"
                + "9 4 6 8 0 10 9 0 5 3\n"
                + "9 10 10 0 10 10 9 0 5 3\n"
                + "0", "21\n"
                + "18\n"
                + "27")
        );
    }
}