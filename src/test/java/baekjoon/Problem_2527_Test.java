package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2527_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2527());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3 10 50 60 100 100 200 300\n"
                    + "45 50 600 600 400 450 500 543\n"
                    + "11 120 120 230 50 40 60 440\n"
                    + "35 56 67 90 67 80 500 600",
                "d\na\na\nb"
            ),
            Arguments.of(
                "0 0 4 4 1 5 3 7\n"
                    + "0 0 4 4 5 5 7 7\n"
                    + "0 0 4 4 5 1 7 3\n"
                    + "0 0 4 4 5 -7 7 -5",
                "d\nd\nd\nd"
            ),
            Arguments.of(
                "1 1 4 4 2 6 3 7\n"
                    + "1 1 4 4 6 6 7 7\n"
                    + "1 1 4 4 6 2 7 3\n"
                    + "1 8 4 10 6 1 7 1",
                "d\nd\nd\nd"
            ),
            Arguments.of(
                "0 0 4 4 -4 4 0 8\n"
                    + "0 0 4 4 -4 -4 0 0\n"
                    + "0 0 4 4 4 4 8 8\n"
                    + "0 0 4 4 4 -4 8 0",
                "c\nc\nc\nc"
            ),
            Arguments.of(
                "0 0 4 4 -1 4 5 7\n"
                    + "0 0 4 4 -1 3 0 8\n"
                    + "0 0 4 4 -1 -1 0 3\n"
                    + "0 0 4 4 -1 -1 2 0",
                "b\nb\nb\nb"
            ),
            Arguments.of(
                "0 0 4 4 3 -1 5 0\n"
                    + "0 0 4 4 4 -1 5 7\n"
                    + "0 0 4 4 4 3 5 8\n"
                    + "0 0 4 4 3 4 8 8",
                "b\nb\nb\nb"
            ),
            Arguments.of(
                "10 10 20 20 3 3 5 5\n"
                    + "10 10 20 20 3 3 5 5\n"
                    + "10 10 20 20 3 3 5 5\n"
                    + "10 10 20 20 3 3 5 5",
                "d\nd\nd\nd"
            ),
            Arguments.of(
                "0 0 100 100 100 200 300 300\n"
                    + "0 0 100 100 100 200 300 300\n"
                    + "0 0 100 100 100 200 300 300\n"
                    + "0 0 100 100 100 200 300 300\n",
                "d\nd\nd\nd"
            )
        );
    }
}