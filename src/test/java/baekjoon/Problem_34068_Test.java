package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_34068_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_34068());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 3\n"
                + "1 3\n"
                + "1 2\n"
                + "2 1", "3"),
            Arguments.of("3 0", "3")
        );
    }
}