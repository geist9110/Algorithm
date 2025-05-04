package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1213_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1213());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("AABB", "ABBA"),
            Arguments.of("AAABB", "ABABA"),
            Arguments.of("ABACABA", "AABCBAA"),
            Arguments.of("ABCD", "I'm Sorry Hansoo")
        );
    }
}