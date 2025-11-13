package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_27466_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27466());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("7 5\nIKSAXAC", "YES\nKSAAC"),
                Arguments.of("5 4\nKSIIC", "NO"),
                Arguments.of("5 4\nAAABU", "YES\nAAAB"),
                Arguments.of("7 5\nSAASSSS", "NO"),
                Arguments.of("7 5\nSASSSSS", "NO"));
    }

}
