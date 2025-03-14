package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1339_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1339());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\nAAA\nAAA", "1998"),
                Arguments.of("2\nGCF\nACDEB", "99437"),
                Arguments.of("10\nA\nB\nC\nD\nE\nF\nG\nH\nI\nJ", "45"),
                Arguments.of("2\nAB\nBA", "187"),
                Arguments.of("3\nA\nB\nB", "26"));
    }
}
