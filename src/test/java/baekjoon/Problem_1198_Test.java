package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1198_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1198(), 1e-9);
    }

    protected static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3\n"
                    + "1 1\n"
                    + "2 3\n"
                    + "3 2", "1.5"
            ),
            Arguments.of(
                "4\n"
                    + "1 1\n"
                    + "1 2\n"
                    + "3 3\n"
                    + "2 1", "1.5"
            ),
            Arguments.of(
                "8\n"
                    + "1 2\n"
                    + "1 3\n"
                    + "2 4\n"
                    + "3 4\n"
                    + "4 3\n"
                    + "4 2\n"
                    + "3 1\n"
                    + "2 1", "3.0"
            ),
            Arguments.of(
                "7\n"
                    + "6 2\n"
                    + "2 1\n"
                    + "1 2\n"
                    + "1 4\n"
                    + "2 6\n"
                    + "5 6\n"
                    + "6 5", "10.0"
            )
        );
    }
}