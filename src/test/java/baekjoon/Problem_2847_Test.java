package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2847_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2847());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n5\n5\n5", "3"),
            Arguments.of("4\n5\n3\n7\n5", "6")
        );
    }
}