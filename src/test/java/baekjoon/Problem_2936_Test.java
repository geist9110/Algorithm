package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2936_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2936());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("0 0", "125.00 125.00"),
            Arguments.of("230 20", "0.00 114.13"),
            Arguments.of("0 40", "148.81 101.19")
        );
    }
}