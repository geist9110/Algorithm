package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2947_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2947());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2 1 5 3 4",
                "1 2 5 3 4\n"
                    + "1 2 3 5 4\n"
                    + "1 2 3 4 5"
            ),
            Arguments.of(
                "2 3 4 5 1",
                "2 3 4 1 5\n"
                    + "2 3 1 4 5\n"
                    + "2 1 3 4 5\n"
                    + "1 2 3 4 5"
            )
        );
    }
}