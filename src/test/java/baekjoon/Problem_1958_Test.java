package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1958_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1958());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("abcdefghijklmn\n"
                + "bdefg\n"
                + "efg", "3"),
            Arguments.of("acb\n"
                + "ab\n"
                + "ab", "2"),
            Arguments.of("axbyc\n"
                + "aibjc\n"
                + "ambnc", "3")
        );
    }
}