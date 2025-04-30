package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15973_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15973());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1 2 3 5\n3 5 8 11", "POINT"),
            Arguments.of("3 5 9 10\n5 4 8 11", "FACE"),
            Arguments.of("1 2 3 5\n9 3 12 7", "NULL"),
            Arguments.of("3 5 9 10\n9 3 12 7", "LINE"),
            Arguments.of("1 1 5 5\n1 2 2 4", "FACE"),
            Arguments.of("0 0 1 1\n 1 2 2 3", "NULL"),
            Arguments.of("0 0 1 1\n 1 -2 2 -1", "NULL")
        );
    }
}