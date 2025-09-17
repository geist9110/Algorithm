package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_21394_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_21394());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4\n"
                    + "0 0 0 0 0 2 1 1 1\n"
                    + "1 1 1 1 1 1 1 1 1\n"
                    + "1 1 3 0 0 0 0 0 0\n"
                    + "1 2 2 0 0 0 0 0 0",
                "9 9 7 8 9\n"
                    + "9 8 5 3 1 2 4 7 9\n"
                    + "3 3 1 2 3\n"
                    + "3 2 1 2 3"
            )
        );
    }
}