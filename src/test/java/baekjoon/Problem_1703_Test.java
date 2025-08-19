package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1703_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1703());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "1 3 0\n"
                    + "2 3 0 2 0\n"
                    + "3 3 0 2 0 2 0\n"
                    + "3 3 0 2 1 2 3\n"
                    + "2 4 1 3 4\n"
                    + "4 5 0 5 1 5 2 5 101\n"
                    + "0", "3\n"
                    + "6\n"
                    + "12\n"
                    + "7\n"
                    + "5\n"
                    + "489"
            )
        );
    }
}