package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11896_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11896());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3 4", "4"),
            Arguments.of("4 5", "4"),
            Arguments.of("4 6", "10"),
            Arguments.of("3 5", "4"),
            Arguments.of("1 2", "0"),
            Arguments.of("1 4", "4"),
            Arguments.of("1 1", "0")
        );
    }
}