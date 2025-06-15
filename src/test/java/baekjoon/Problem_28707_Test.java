package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_28707_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_28707());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4\n"
                    + "1 4 3 2\n"
                    + "4\n"
                    + "1 2 4\n"
                    + "2 3 3\n"
                    + "3 4 2\n"
                    + "1 4 10", "7"
            ),
            Arguments.of(
                "4\n"
                    + "1 3 1 3\n"
                    + "6\n"
                    + "1 2 3\n"
                    + "1 3 3\n"
                    + "1 4 3\n"
                    + "2 3 3\n"
                    + "2 4 1\n"
                    + "3 4 1", "2"
            ),
            Arguments.of(
                "5\n"
                    + "5 4 3 2 1\n"
                    + "2\n"
                    + "1 2 5\n"
                    + "3 4 3", "-1"
            )
        );
    }
}