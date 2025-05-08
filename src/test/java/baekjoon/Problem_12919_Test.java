package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_12919_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12919());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("A\nBABA", "1"),
            Arguments.of("BAAAAABAA\nBAABAAAAAB", "1"),
            Arguments.of("A\nABBA", "0")
        );
    }
}