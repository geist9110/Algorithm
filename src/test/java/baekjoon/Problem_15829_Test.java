package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15829_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15829());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\nabcde", "4739715"),
            Arguments.of("3\nzzz", "25818"),
            Arguments.of("1\ni", "9"),
            Arguments.of("1\nz", "26"),
            Arguments.of("2\nzz", "832"),
            Arguments.of("3\nzzz", "25818"),
            Arguments.of("4\nzzzz", "800384"),
            Arguments.of("5\nzzzzz", "24811930"),
            Arguments.of("6\nzzzzzz", "769169856"),
            Arguments.of("7\nzzzzzzz", "387475633")
        );
    }
}