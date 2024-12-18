package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2096_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2096());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "1 2 3\n"
                + "4 5 6\n"
                + "4 9 0", "18 6"),
            Arguments.of("3\n"
                + "0 0 0\n"
                + "0 0 0\n"
                + "0 0 0", "0 0")
        );
    }
}