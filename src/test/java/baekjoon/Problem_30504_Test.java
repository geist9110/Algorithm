package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_30504_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_30504());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n1 2 3 4 5\n7 3 2 5 4", "2 3 4 5 7"),
                Arguments.of("3\n1 3 10000\n9999 9999 9999", "-1"));
    }

}
