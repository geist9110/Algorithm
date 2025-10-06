package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_29160_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_29160());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "11 1\n"
                    + "1 5\n"
                    + "2 4\n"
                    + "3 2\n"
                    + "4 3\n"
                    + "5 10\n"
                    + "6 9\n"
                    + "7 6\n"
                    + "8 8\n"
                    + "9 11\n"
                    + "10 5\n"
                    + "11 6", "58"
            )
        );
    }
}