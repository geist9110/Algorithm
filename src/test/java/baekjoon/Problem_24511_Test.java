package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_24511_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24511());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n0 1 1 0\n1 2 3 4\n3\n2 4 7", "4 1 2"),
            Arguments.of("5\n1 1 1 1 1\n1 2 3 4 5\n3\n1 3 5", "1 3 5")
        );
    }
}