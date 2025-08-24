package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1337_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1337());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3\n"
                    + "5\n"
                    + "6\n"
                    + "7", "2"
            ),
            Arguments.of(
                "6\n"
                    + "5\n"
                    + "7\n"
                    + "9\n"
                    + "8492\n"
                    + "8493\n"
                    + "192398", "2"
            ),
            Arguments.of(
                "4\n"
                    + "1000\n"
                    + "2000\n"
                    + "3000\n"
                    + "4000", "4"
            ),
            Arguments.of(
                "7\n"
                    + "6\n"
                    + "1\n"
                    + "9\n"
                    + "5\n"
                    + "7\n"
                    + "15\n"
                    + "8", "0"
            ),
            Arguments.of(
                "4\n"
                    + "1\n"
                    + "2\n"
                    + "4\n"
                    + "5\n",
                "1"
            )
        );
    }
}