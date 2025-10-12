package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_32687_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_32687());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("100 120 2 1", "2"),
            Arguments.of("200 300 2 3", "3"),
            Arguments.of("100 10000 3 3", "600")
        );
    }
}