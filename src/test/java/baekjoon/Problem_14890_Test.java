package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14890_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14890());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("6 2\n"
                + "3 3 3 3 3 3\n"
                + "2 3 3 3 3 3\n"
                + "2 2 2 3 2 3\n"
                + "1 1 1 2 2 2\n"
                + "1 1 1 3 3 1\n"
                + "1 1 2 3 3 2", "3"),
            Arguments.of("6 2\n"
                + "3 2 1 1 2 3\n"
                + "3 2 2 1 2 3\n"
                + "3 2 2 2 3 3\n"
                + "3 3 3 3 3 3\n"
                + "3 3 3 3 2 2\n"
                + "3 3 3 3 2 2", "7"),
            Arguments.of("6 3\n"
                + "3 2 1 1 2 3\n"
                + "3 2 2 1 2 3\n"
                + "3 2 2 2 3 3\n"
                + "3 3 3 3 3 3\n"
                + "3 3 3 3 2 2\n"
                + "3 3 3 3 2 2", "3"),
            Arguments.of("6 1\n"
                + "3 2 1 1 2 3\n"
                + "3 2 2 1 2 3\n"
                + "3 2 2 2 3 3\n"
                + "3 3 3 3 3 3\n"
                + "3 3 3 3 2 2\n"
                + "3 3 3 3 2 2", "11")
        );
    }
}