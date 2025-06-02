package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_8979_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_8979());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 3\n"
                + "1 1 2 0\n"
                + "2 0 1 0\n"
                + "3 0 1 0\n"
                + "4 0 0 1", "2"),
            Arguments.of("4 2\n"
                + "1 3 0 0\n"
                + "3 0 0 2\n"
                + "4 0 2 0\n"
                + "2 0 2 0", "2")
        );
    }
}