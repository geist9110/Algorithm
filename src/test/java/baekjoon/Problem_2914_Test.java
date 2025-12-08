package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2914_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2914());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("38 24", "875"),
                Arguments.of("1 100", "100"),
                Arguments.of("10 10", "91"));
    }

}
