package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_24313_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24313());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 7\n8\n1", "0"),
            Arguments.of("7 7\n8\n10", "1"),
            Arguments.of("0 1\n1\n1", "1"),
            Arguments.of("2 1\n1\n3", "0"),
            Arguments.of("0 100\n1\n100", "1"),
            Arguments.of("100 1\n100\n1", "0"),
            Arguments.of("-1 3\n1\n1", "0"),
            Arguments.of("-1 3\n1\n2", "1"),
            Arguments.of("4 -7\n3\n1", "0")
        );
    }
}