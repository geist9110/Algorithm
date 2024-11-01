package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10988_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10988());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("level", "1"),
            Arguments.of("baekjoon", "0"),
            Arguments.of("noon", "1"),
            Arguments.of("online", "0"),
            Arguments.of("judge", "0"),
            Arguments.of("a", "1")
        );
    }
}