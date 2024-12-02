package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_30804_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_30804());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n5 1 1 2 1", "4"),
            Arguments.of("3\n1 1 1", "3"),
            Arguments.of("9\n1 2 3 4 5 6 7 8 9", "2"),
            Arguments.of("8\n1 2 2 3 3 3 3 4", "6"),
            Arguments.of("1\n1", "1")
        );
    }
}