package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_4485_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4485());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of(
                "3\n5 5 4\n3 9 1\n3 2 7\n5\n3 7 2 0 1\n2 8 0 9 1\n1 2 1 8 1\n9 8 9 2 0\n3 6 5 1 5\n7\n9 0 5 1 1 5 3\n4 1 2 1 6 5 3\n0 7 6 1 6 8 5\n1 1 7 8 3 2 3\n9 4 0 7 6 4 1\n5 8 3 2 4 8 3\n7 4 8 4 8 3 4\n0",
                "Problem 1: 20\nProblem 2: 19\nProblem 3: 36"));
    }
}
