package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_20413_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20413());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n30 60 90 150\nBSG", "118"),
                Arguments.of("10\n257 269 367 500\nBSGGGGPPDD", "2499"));
    }

}
