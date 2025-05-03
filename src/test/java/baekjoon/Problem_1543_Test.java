package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1543_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1543());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("ababababa\naba", "2"),
            Arguments.of("a a a a a\na a", "2"),
            Arguments.of("ababababa\nababa", "1"),
            Arguments.of("aaaaaaa\naa", "3")
        );
    }
}