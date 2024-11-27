package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2346_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2346());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n3 2 1 -3 -1", "1 4 5 3 2"),
            Arguments.of("1\n1", "1"),
            Arguments.of("10\n1 1 1 1 1 1 1 1 1 1", "1 2 3 4 5 6 7 8 9 10"),
            Arguments.of("5\n5 5 5 5 5", "1 2 4 5 3")
        );
    }
}