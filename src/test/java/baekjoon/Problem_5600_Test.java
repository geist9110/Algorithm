package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_5600_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5600());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2 2 2\n4\n2 4 5 0\n2 3 6 0\n1 4 5 0\n2 3 5 1", "2\n1\n1\n0\n1\n0"));
    }

}
