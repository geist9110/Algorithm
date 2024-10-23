package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10810_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10810());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 4\n1 2 3\n3 4 4\n1 4 1\n2 2 2", "1 2 1 1 0"),
            Arguments.of("1 1\n1 1 1", "1")
        );
    }
}