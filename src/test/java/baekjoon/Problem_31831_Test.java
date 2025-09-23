package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_31831_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_31831());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("10 10\n2 -1 4 7 4 -8 3 6 4 -7", "6"),
            Arguments.of("5 1\n1 -1 -1 -1 1", "2")
        );
    }
}