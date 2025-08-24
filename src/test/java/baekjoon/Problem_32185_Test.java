package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_32185_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_32185());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3 2\n"
                    + "10 10 10\n"
                    + "10 9 10\n"
                    + "9 10 11\n"
                    + "10 15 10", "0 2"
            ),
            Arguments.of(
                "5 4\n"
                    + "5 5 5\n"
                    + "5 5 4\n"
                    + "5 5 5\n"
                    + "5 5 6\n"
                    + "5 5 7\n"
                    + "5 5 8", "0 2 1"
            ),
            Arguments.of(
                "5 6\n"
                    + "1 1 1\n"
                    + "1 1 1\n"
                    + "1 1 1\n"
                    + "1 1 1\n"
                    + "1 1 1\n"
                    + "1 1 1",
                "0 1 2 3 4 5"
            ),
            Arguments.of(
                "1 1\n"
                    + "1 1 1\n"
                    + "1 1 1",
                "0"
            )
        );
    }
}