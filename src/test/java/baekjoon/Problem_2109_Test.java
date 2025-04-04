package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2109_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2109());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7\n20 1\n2 1\n10 3\n100 2\n8 2\n5 20\n50 10", "185")
        );
    }
}