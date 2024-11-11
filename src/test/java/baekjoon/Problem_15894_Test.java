package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15894_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15894());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1", "4"),
            Arguments.of("2", "8"),
            Arguments.of("3", "12")
        );
    }
}