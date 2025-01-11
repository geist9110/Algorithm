package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2473_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2473());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("5\n-2 6 -97 -6 98", "-97 -2 98"),
                Arguments.of("7\n-2 -3 -24 -6 98 100 61", "-6 -3 -2"),
                Arguments.of("6\n-10 0 2 3 4 8", "-10 2 8"), Arguments.of("5\n1 2 3 4 5", "1 2 3"),
                Arguments.of("5\n1000000000 999999999 999999998 999999997 999999996",
                        "999999996 999999997 999999998"),
                Arguments.of("6\n1000000000 -1000000000 0 1 999999998 -999999998",
                        "-1000000000 0 1000000000"),
                Arguments.of("6\n8 -1 2 -10 10 7", "-10 2 8"));
    }
}
