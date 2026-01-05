package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_18130_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_18130());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "5 12\n100 2 100\n200 3 100\n0 10 500\n0 10 600\n1000 13 100", "3 500"));
    }

}
