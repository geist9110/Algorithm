package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14719_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14719());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4 4\n"
                    + "3 0 1 4", "5"
            ),
            Arguments.of(
                "4 8\n"
                    + "3 1 2 3 4 1 1 2", "5"
            ),
            Arguments.of(
                "3 5\n"
                    + "0 0 0 2 0", "0"
            )
        );
    }
}