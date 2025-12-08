package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_4781_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4781());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2 8.00\n700 7.00\n199 2.00\n3 8.00\n700 7.00\n299 3.00\n499 5.00\n0 0.00", "796\n798"));
    }

}
