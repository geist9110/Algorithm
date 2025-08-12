package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_18222_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_18222());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1", "0"),
            Arguments.of("2", "1"),
            Arguments.of("3", "1"),
            Arguments.of("4", "0"),
            Arguments.of("5", "1"),
            Arguments.of("6", "0"),
            Arguments.of("7", "0"),
            Arguments.of("8", "1"),
            Arguments.of("9", "1"),
            Arguments.of("10", "0")
        );
    }
}