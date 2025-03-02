package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1915_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1915());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4 4\n0100\n0111\n1110\n0010", "4"),
                Arguments.of("1 1\n1", "1"),
                Arguments.of("1 3\n000", "0"),
                Arguments.of("1 3\n010", "1")

        );
    }
}
