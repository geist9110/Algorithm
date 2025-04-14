package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1297_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1297());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("52 9 16", "25 45"),
            Arguments.of("7 2 3", "3 5"),
            Arguments.of("13 7 10", "7 10"),
            Arguments.of("7 32 47", "3 5"),
            Arguments.of("11 15 16", "7 8")
        );
    }
}