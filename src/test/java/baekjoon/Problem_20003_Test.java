package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_20003_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20003());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\n1 4\n2 5", "1 20"),
                Arguments.of("3\n1 3\n5 2\n3 4", "1 12"),
                Arguments.of("2\n6 7\n9 14", "3 14"));
    }

}
