package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1120_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1120());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("adaabc aababbc", "2"),
            Arguments.of("hello xello", "1"),
            Arguments.of("koder topcoder", "1"),
            Arguments.of("abc topabcoder", "0"),
            Arguments.of("giorgi igroig", "6")
        );
    }
}