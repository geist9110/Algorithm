package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14916_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14916());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("13", "5"),
            Arguments.of("14", "4"),
            Arguments.of("1", "-1"),
            Arguments.of("2", "1"),
            Arguments.of("3", "-1"),
            Arguments.of("4", "2"),
            Arguments.of("5", "1")
        );
    }
}