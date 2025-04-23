package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1064_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1064(), 10e-9);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("0 0 0 1 1 0", "0.8284271247461898"),
            Arguments.of("0 0 4 0 0 3", "4.0"),
            Arguments.of("0 0 1 0 47 0", "-1.0"),
            Arguments.of("1 2 3 4 8 7", "11.547796284592874"),
            Arguments.of("2 -1 -7 2 -1 0", "-1.0"),
            Arguments.of("0 0 1 1 2 0", "1.171572875253809709050756"),
            Arguments.of("0 0 1 1 -1 -1", "-1.0"),
            Arguments.of("-5000 -5000 -2 -1 4997 4999", "14140.72148088632569472"),
            Arguments.of("-5000 -5000 4988 4988 4999 4999", "-1"),
            Arguments.of("-5000 -5000 2073 2073 5000 5000", "-1")
        );
    }

}