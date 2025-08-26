package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_25344_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25344());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n"
                + "1 2 3", "6"),
            Arguments.arguments("3\n1", "1")
        );
    }
}