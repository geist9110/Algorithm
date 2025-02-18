package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11052_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11052());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4\n1 5 6 7", "10"),
                Arguments.of("5\n10 9 8 7 6", "50"),
                Arguments.of("10\n1 1 2 3 5 8 13 21 34 55", "55"),
                Arguments.of("4\n5 2 8 10", "20"),
                Arguments.of("4\n3 5 15 16", "18"));
    }

}
