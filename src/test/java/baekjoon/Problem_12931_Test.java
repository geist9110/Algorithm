package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_12931_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12931());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\n2 1", "3"),
                Arguments.of("3\n16 16 16", "7"),
                Arguments.of("1\n100", "9"),
                Arguments.of("5\n0 0 1 0 1", "2"),
                Arguments.of("1\n0", "0"),
                Arguments.of("3\n3 1 2", "5"));
    }

}
