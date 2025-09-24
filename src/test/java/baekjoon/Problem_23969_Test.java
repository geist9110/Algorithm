package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_23969_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_23969());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("6 10\n"
                + "4 6 5 1 3 2", "1 3 2 4 5 6"),
            Arguments.of("6 12\n"
                + "4 6 5 1 3 2", "-1")
        );
    }
}