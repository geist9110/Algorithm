package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_12927_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12927());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("YYYYYY", "1"),
            Arguments.of("YNYNYNYNY", "2"),
            Arguments.of("NNNNNNNNNN", "0"),
            Arguments.of("YYYNYYYNYYYNYYNYYYYN", "4")
        );
    }
}