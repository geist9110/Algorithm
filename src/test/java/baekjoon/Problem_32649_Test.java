package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_32649_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_32649());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 36 3", "2 4 36"),
            Arguments.of("2 8 5", "-1"),
            Arguments.of("2 5 2", "-1"),
            Arguments.of("1 10 5", "-1"),
            Arguments.of("1 10 4", "1 2 5 10")
        );
    }
}