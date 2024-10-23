package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11382_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11382());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("77 77 7777", "7931"),
            Arguments.of("12 12 12", "36"),
            Arguments.of("1000000000000 1000000000000 1000000000000", "3000000000000")
        );
    }
}