package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_24954_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24954());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4\n10 15 20 25\n2\n3 10\n2 20\n0\n1\n4 10\n1\n1 10", "36"));
    }

}
