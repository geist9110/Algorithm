package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2600_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2600());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1 3 4\n4 1\n5 5\n10 2\n15 16\n30 14", "A\nB\nA\nA\nB"));
    }

}
