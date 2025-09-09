package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10539_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10539());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "1\n"
                    + "2", "2"
            ),
            Arguments.of(
                "4\n"
                    + "3 2 3 5", "3 1 5 11"
            ),
            Arguments.of(
                "5\n"
                    + "1 2 2 3 4", "1 3 2 6 8"
            )
        );
    }
}