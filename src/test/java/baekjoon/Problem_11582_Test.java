package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11582_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11582());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("8\n"
                + "1 5 2 4 2 9 7 3\n"
                + "4", "1 5 2 4 2 9 3 7"),
            Arguments.of("8\n"
                + "1 5 2 4 2 9 7 3\n"
                + "2", "1 2 4 5 2 3 7 9"),
            Arguments.of("8\n"
                + "1 5 2 4 2 9 7 3\n"
                + "1", "1 2 2 3 4 5 7 9"),
            Arguments.of("8\n"
                + "8 7 6 5 4 3 2 1\n"
                + "2", "5 6 7 8 1 2 3 4")
        );
    }
}