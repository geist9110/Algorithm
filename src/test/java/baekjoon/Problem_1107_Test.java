package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1107_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1107());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5457\n3\n6 7 8", "6"),
            Arguments.of("100\n5\n0 1 2 3 4", "0"),
            Arguments.of("500000\n8\n0 2 3 4 6 7 8 9", "11117"),
            Arguments.of("100\n3\n1 0 5", "0"),
            Arguments.of("14124\n0", "5"),
            Arguments.of("1\n9\n1 2 3 4 5 6 7 8 9", "2"),
            Arguments.of("80000\n2\n8 9", "2228"),
            Arguments.of("9999\n8\n2 3 4 5 6 7 8 9", "6")
        );
    }
}