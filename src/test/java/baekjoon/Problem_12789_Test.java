package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_12789_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12789());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n5 4 1 3 2", "Nice"),
            Arguments.of("5\n1 2 3 4 5", "Nice"),
            Arguments.of("5\n1 2 4 5 3", "Sad"),
            Arguments.of("5\n5 3 1 2 4", "Nice")
        );
    }
}