package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_7453_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_7453());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("6\n" +
                        "-45 22 42 -16\n" + //
                        "-41 -27 56 30\n" + //
                        "-36 53 -37 77\n" + //
                        "-36 30 -75 -46\n" + //
                        "26 -38 -10 62\n" + //
                        "-32 -54 -6 45", "5"),
                Arguments.of("6\n" + //
                        "0 0 0 0\n" + //
                        "0 0 0 0\n" + //
                        "0 0 0 0\n" + //
                        "0 0 0 0\n" + //
                        "0 0 0 0\n" + //
                        "0 0 0 0", "1296"));
    }
}
