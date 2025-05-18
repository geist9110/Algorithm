package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2573_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2573());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5 7\n"
                    + "0 0 0 0 0 0 0\n"
                    + "0 2 4 5 3 0 0\n"
                    + "0 3 0 2 5 2 0\n"
                    + "0 7 6 2 4 0 0\n"
                    + "0 0 0 0 0 0 0", "2"
            )
        );
    }
}