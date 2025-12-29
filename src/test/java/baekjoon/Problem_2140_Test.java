package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2140_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2140());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n11100\n2###1\n3###1\n2###1\n12210", "6"),
                Arguments.of("1\n0", "0"),
                Arguments.of("5\n11211\n1###1\n2###2\n1###1\n11211", "5"));
    }

}
