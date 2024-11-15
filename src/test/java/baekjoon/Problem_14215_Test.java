package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14215_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14215());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1 2 3", "5"),
            Arguments.of("2 2 2", "6"),
            Arguments.of("1 100 1", "3"),
            Arguments.of("41 64 16", "113")
        );
    }
}