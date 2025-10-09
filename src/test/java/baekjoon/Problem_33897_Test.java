package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_33897_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_33897());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "9\n"
                    + "6 7 8 9 3 4 5 1 2", "3 4"
            ),
            Arguments.of(
                "5\n"
                    + "1 2 3 4 5", "1 5"
            ),
            Arguments.of(
                "5\n"
                    + "1 3 2 3 1", "3 2"
            )
        );
    }
}