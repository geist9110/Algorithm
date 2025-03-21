package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_13241_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_13241());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1 1", "1"),
            Arguments.of("3 5", "15"),
            Arguments.of("1 123", "123"),
            Arguments.of("121 199", "24079")
        );
    }
}