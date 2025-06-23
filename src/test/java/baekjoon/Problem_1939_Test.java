package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1939_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1939());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3 3\n"
                    + "1 2 2\n"
                    + "3 1 3\n"
                    + "2 3 2\n"
                    + "1 3", "3"
            ),
            Arguments.of(
                "3 3\n"
                    + "1 2 4\n"
                    + "3 1 3\n"
                    + "2 3 4\n"
                    + "1 3", "4"
            ),
            Arguments.of(
                "3 5\n"
                    + "1 2 2\n"
                    + "1 2 3\n"
                    + "1 2 1\n"
                    + "2 3 2\n"
                    + "2 3 1\n"
                    + "1 3", "2"
            ),
            Arguments.of(
                "3 3\n"
                    + "1 2 2\n"
                    + "3 1 2\n"
                    + "2 3 2\n"
                    + "1 3", "2"
            )
        );
    }
}