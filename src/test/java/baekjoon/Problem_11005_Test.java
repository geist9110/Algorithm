package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11005_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11005());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("60466175 36", "ZZZZZ"),
            Arguments.of("60466174 36", "ZZZZY"),
            Arguments.of("7 2", "111"),
            Arguments.of("1 2", "1")
        );
    }
}