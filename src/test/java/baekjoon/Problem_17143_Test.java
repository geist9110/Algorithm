package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17143_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17143());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4 6 8\n"
                    + "4 1 3 3 8\n"
                    + "1 3 5 2 9\n"
                    + "2 4 8 4 1\n"
                    + "4 5 0 1 4\n"
                    + "3 3 1 2 7\n"
                    + "1 5 8 4 3\n"
                    + "3 6 2 1 2\n"
                    + "2 2 2 3 5", "22"
            ),
            Arguments.of(
                "100 100 0", "0"
            ),
            Arguments.of(
                "2 2 4\n"
                    + "1 1 1 1 1\n"
                    + "2 2 2 2 2\n"
                    + "1 2 1 2 3\n"
                    + "2 1 2 1 4", "4"
            )
        );
    }
}