package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_3985_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3985());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "10\n"
                    + "3\n"
                    + "2 4\n"
                    + "7 8\n"
                    + "6 9", "3\n1"
            ),
            Arguments.of(
                "10\n"
                    + "3\n"
                    + "1 3\n"
                    + "5 7\n"
                    + "8 9", "1\n1"
            ),
            Arguments.of(
                "10\n"
                    + "5\n"
                    + "1 1\n"
                    + "1 2\n"
                    + "1 3\n"
                    + "1 4\n"
                    + "7 8", "4\n5"
            )
        );
    }
}