package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1275_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1275());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5 2\n"
                    + "1 2 3 4 5\n"
                    + "2 3 3 1\n"
                    + "3 5 4 1", "5\n10"
            ),
            Arguments.of(
                "1 1\n1\n1 1 1 1\n1", "1"
            )
        );
    }
}