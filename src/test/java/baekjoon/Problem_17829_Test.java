package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17829_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17829());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4\n"
                    + "-6 -8 7 -4\n"
                    + "-5 -5 14 11\n"
                    + "11 11 -1 -1\n"
                    + "4 9 -2 -4", "11"
            ),
            Arguments.of(
                "8\n"
                    + "-1 2 14 7 4 -5 8 9\n"
                    + "10 6 23 2 -1 -1 7 11\n"
                    + "9 3 5 -2 4 4 6 6\n"
                    + "7 15 0 8 21 20 6 6\n"
                    + "19 8 12 -8 4 5 2 9\n"
                    + "1 2 3 4 5 6 7 8\n"
                    + "9 10 11 12 13 14 15 16\n"
                    + "17 18 19 20 21 22 23 24", "17"
            )
        );
    }
}