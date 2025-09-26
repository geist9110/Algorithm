package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1487_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1487());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3\n"
                    + "13 15\n"
                    + "22 30\n"
                    + "35 40", "0"
            ),
            Arguments.of(
                "3\n"
                    + "13 5\n"
                    + "22 15\n"
                    + "35 30", "13"
            ),
            Arguments.of(
                "5\n"
                    + "10 1\n"
                    + "10 5\n"
                    + "20 11\n"
                    + "20 15\n"
                    + "5 0", "10"
            ),
            Arguments.of(
                "3\n"
                    + "13 0\n"
                    + "22 0\n"
                    + "35 0", "22"
            ),
            Arguments.of(
                "8\n"
                    + "13 12\n"
                    + "17 1\n"
                    + "14 5\n"
                    + "30 10\n"
                    + "19 3\n"
                    + "17 2\n"
                    + "55 40\n"
                    + "16 19", "17"
            )
        );
    }
}