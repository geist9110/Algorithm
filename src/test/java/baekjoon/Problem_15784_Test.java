package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15784_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15784());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5 3 2\n"
                    + "10 2 3 24 4\n"
                    + "21 4 5 12 1\n"
                    + "24 52 4 2 2\n"
                    + "2 4 3 2 32\n"
                    + "1 4 32 2 4", "HAPPY"
            ),
            Arguments.of(
                "1 1 1\n"
                    + "1",
                "HAPPY"
            ),
            Arguments.of(
                "3 2 2\n"
                    + "1 999 1\n"
                    + "1 1 1\n"
                    + "1 1 1",
                "ANGRY"
            )
        );
    }
}