package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10707_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10707());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "9\n"
                    + "100\n"
                    + "20\n"
                    + "3\n"
                    + "10", "90"
            ),
            Arguments.of(
                "8\n"
                    + "300\n"
                    + "100\n"
                    + "10\n"
                    + "250", "1800"
            )
        );
    }
}