package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2042_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2042());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 2 2\n"
                + "1\n"
                + "2\n"
                + "3\n"
                + "4\n"
                + "5\n"
                + "1 3 6\n"
                + "2 2 5\n"
                + "1 5 2\n"
                + "2 3 5", "17\n"
                + "12")
        );
    }
}