package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1068_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1068());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n-1 0 0 1 1\n2", "2"),
            Arguments.of("5\n-1 0 0 1 1\n1", "1"),
            Arguments.of("5\n-1 0 0 1 1\n0", "0"),
            Arguments.of("9\n-1 0 0 2 2 4 4 6 6\n4", "2"),
            Arguments.of("3\n2 -1 1\n0", "1"),
            Arguments.of("6\n2 3 3 5 2 -1\n3", "1")
        );
    }
}