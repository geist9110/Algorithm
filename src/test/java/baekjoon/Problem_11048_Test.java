package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11048_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11048());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 4\n1 2 3 4\n0 0 0 5\n9 8 7 6", "31"),
                Arguments.of("3 3\n1 0 0\n0 1 0\n0 0 1", "3"),
                Arguments.of("4 3\n1 2 3\n6 5 4\n7 8 9\n12 11 10", "47"));
    }
}
