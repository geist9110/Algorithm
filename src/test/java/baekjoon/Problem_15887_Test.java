package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_15887_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15887());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n2 1 5 4 3", "2\n1 2\n3 5"),
                Arguments.of("5\n5 2 1 4 3", "2\n1 3\n3 5"),
                Arguments.of("1\n1", "0"),
                Arguments.of("5\n1 5 4 3 2", "1\n2 5"));
    }
}
