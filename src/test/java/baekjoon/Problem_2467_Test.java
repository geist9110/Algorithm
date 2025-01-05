package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2467_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2467());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n-99 -2 -1 4 98", "-99 98"),
            Arguments.of("4\n-100 -2 -1 103", "-2 -1")
        );
    }
}