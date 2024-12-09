package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1074_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1074());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 3 1", "11"),
            Arguments.of("3 7 7", "63"),
            Arguments.of("1 0 0", "0"),
            Arguments.of("4 7 7", "63"),
            Arguments.of("10 511 511", "262143"),
            Arguments.of("10 512 512", "786432")
        );
    }
}