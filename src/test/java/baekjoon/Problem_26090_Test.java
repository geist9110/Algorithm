package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_26090_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_26090());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4\n2 7 4 1", "3"),
                Arguments.of("4\n0 0 1 0", "0"));
    }

}
