package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1261_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1261());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("3 3\n011\n111\n110", "3"),
                Arguments.of("4 2\n0001\n1000", "0"),
                Arguments.of("6 6\n001111\n010000\n001111\n110001\n011010\n100010", "2"),
                Arguments.of("1 1\n0", "0"), Arguments.of("1 3\n0\n1\n0", "1"),
                Arguments.of("4 6\n0000\n1111\n1110\n1000\n0111\n0000", "2"),
                Arguments.of("4 4\n0111\n1111\n1111\n1110", "5"),
                Arguments.of(
                        "15 5\n000000000000000\n111111111111110\n000000000000000\n011111111111111\n000000000000000",
                        "0")

        );
    }
}
