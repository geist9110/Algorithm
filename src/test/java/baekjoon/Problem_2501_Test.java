package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2501_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2501());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("6 3", "3"),
            Arguments.of("25 4", "0"),
            Arguments.of("2735 1", "1")
        );
    }
}