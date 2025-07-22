package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1925_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1925());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("0 0\n"
                + "-3 -3\n"
                + "-3 0", "Jikkak2Triangle"),
            Arguments.of("1 1\n"
                + "0 0\n"
                + "2 100", "DunkakTriangle"),
            Arguments.of("10000 10000\n"
                + "2580 2580\n"
                + "-10000 -10000", "X"),
            Arguments.of("0 0\n"
                + "-3 -3\n"
                + "-3 0", "Jikkak2Triangle"),
            Arguments.of("0 0\n"
                + "-3 0\n"
                + "-3 -3", "Jikkak2Triangle"),
            Arguments.of("1 1\n"
                + "2 2\n"
                + "3 3", "X")
        );
    }
}