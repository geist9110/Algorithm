package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14940_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14940());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("15 15\n"
                + "2 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 0 0 0 0 1\n"
                + "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1\n"
                + "1 1 1 1 1 1 1 1 1 1 0 1 0 0 0\n"
                + "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1", "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14\n"
                + "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15\n"
                + "2 3 4 5 6 7 8 9 10 11 12 13 14 15 16\n"
                + "3 4 5 6 7 8 9 10 11 12 13 14 15 16 17\n"
                + "4 5 6 7 8 9 10 11 12 13 14 15 16 17 18\n"
                + "5 6 7 8 9 10 11 12 13 14 15 16 17 18 19\n"
                + "6 7 8 9 10 11 12 13 14 15 16 17 18 19 20\n"
                + "7 8 9 10 11 12 13 14 15 16 17 18 19 20 21\n"
                + "8 9 10 11 12 13 14 15 16 17 18 19 20 21 22\n"
                + "9 10 11 12 13 14 15 16 17 18 19 20 21 22 23\n"
                + "10 11 12 13 14 15 16 17 18 19 20 21 22 23 24\n"
                + "11 12 13 14 15 16 17 18 19 20 0 0 0 0 25\n"
                + "12 13 14 15 16 17 18 19 20 21 0 29 28 27 26\n"
                + "13 14 15 16 17 18 19 20 21 22 0 30 0 0 0\n"
                + "14 15 16 17 18 19 20 21 22 23 0 31 32 33 34"),
            Arguments.of("5 5\n"
                    + "1 1 1 1 1\n"
                    + "1 0 0 0 1\n"
                    + "1 0 2 0 1\n"
                    + "1 0 0 0 1\n"
                    + "1 1 1 1 1",
                "-1 -1 -1 -1 -1\n"
                    + "-1 0 0 0 -1\n"
                    + "-1 0 0 0 -1\n"
                    + "-1 0 0 0 -1\n"
                    + "-1 -1 -1 -1 -1")
        );
    }
}