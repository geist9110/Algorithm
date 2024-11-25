package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_28278_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_28278());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("9\n4\n1 3\n1 5\n3\n2\n5\n2\n2\n5", "1\n2\n5\n3\n3\n-1\n-1"),
            Arguments.of("3\n4\n2\n5", "1\n-1\n-1"),
            Arguments.of("4\n1 1\n5\n2\n5", "1\n1\n-1"),
            Arguments.of("2\n1 12345\n5", "12345")
        );
    }
}