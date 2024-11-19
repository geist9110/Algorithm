package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_24265_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24265());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7", "21\n2"),
            Arguments.of("1", "0\n2"),
            Arguments.of("2", "1\n2"),
            Arguments.of("3", "3\n2")
        );
    }
}