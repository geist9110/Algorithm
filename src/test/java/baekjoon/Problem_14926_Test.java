package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_14926_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14926());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3", "a1 a2 a3 a1"),
                Arguments.of("5", "a1 a2 a3 a1 a4 a2 a5 a3 a4 a5 a1"));
    }

}
