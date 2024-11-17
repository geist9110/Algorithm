package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_28702_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_28702());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("Fizz\n"
                + "Buzz\n"
                + "11", "Fizz"),
            Arguments.of("980803\n"
                + "980804\n"
                + "FizzBuzz", "980806")
        );
    }
}