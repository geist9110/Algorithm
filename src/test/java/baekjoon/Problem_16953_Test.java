package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_16953_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16953());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 162", "5"),
            Arguments.of("4 42", "-1"),
            Arguments.of("100 40021", "5")
        );
    }
}