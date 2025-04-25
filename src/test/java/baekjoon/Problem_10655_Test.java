package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10655_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10655());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n"
                + "0 0\n"
                + "8 3\n"
                + "11 -1\n"
                + "10 0", "14")
        );
    }
}