package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_19532_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_19532());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1 3 -1 4 1 7", "2 -1"),
            Arguments.of("2 5 8 3 -4 -11", "-1 2"),
            Arguments.of("0 1 1 1 0 1", "1 1")
        );
    }
}