package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2512_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2512());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n120 110 140 150\n485", "127"),
            Arguments.of("5\n70 80 30 40 100\n450", "100")
        );
    }
}