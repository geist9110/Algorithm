package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_12100_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12100());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "2 2 2\n"
                + "4 4 4\n"
                + "8 8 8", "16"),
            Arguments.of("2\n"
                + "0 0\n"
                + "0 4", "4"),
            Arguments.of("3\n"
                + "2 2 2\n"
                + "0 0 0\n"
                + "0 0 0", "4"),
            Arguments.of("3\n"
                + "2 32 256\n"
                + "128 1024 4\n"
                + "512 64 8", "1024"),
            Arguments.of("4\n"
                + "0 0 2 0\n"
                + "0 0 0 0\n"
                + "2 0 0 0\n"
                + "0 0 0 0", "4"),
            Arguments.of("4\n"
                + "4 2 0 0\n"
                + "0 0 0 0\n"
                + "0 0 0 0\n"
                + "2 0 0 0", "8"),
            Arguments.of("4\n"
                + "2 0 2 8\n"
                + "0 0 2 2\n"
                + "0 0 0 0\n"
                + "0 0 0 0", "16"),
            Arguments.of("4\n"
                + "2 4 16 8\n"
                + "8 4 0 0\n"
                + "16 8 2 0\n"
                + "2 8 2 0", "32"),
            Arguments.of("3\n"
                + "0 8 1024\n"
                + "4 0 4\n"
                + "0 1024 32", "2048")
        );
    }
}