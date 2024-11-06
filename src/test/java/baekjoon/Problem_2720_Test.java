package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2720_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2720());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n124\n25\n194", "4 2 0 4\n1 0 0 0\n7 1 1 4")
        );
    }
}