package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1531_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1531());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3 1\n"
                + "21 21 80 80\n"
                + "41 41 60 60\n"
                + "71 71 90 90", "500")
        );
    }
}