package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_29702_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_29702());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\n6\n2",
                        "3000000000000000003\n2000000000000000002\n1000000000000000001\n2000000000000000001\n1000000000000000001"));
    }

}
