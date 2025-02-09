package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11055_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11055());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("10\n1 100 2 50 60 3 5 6 7 8", "113"),
                Arguments.of("10\n1 2 3 4 5 6 7 8 9 10", "55"),
                Arguments.of("10\n10 9 8 7 6 5 4 3 2 1", "10"),
                Arguments.of("10\n10 1 2 3 9 4 5 6 8 7", "29"),
                Arguments.of("1\n1", "1"),
                Arguments.of("2\n1 1", "1"),
                Arguments.of("10\n2 11 3 14 1 200 100 5 101 13", "228")

        );
    }

}
