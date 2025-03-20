package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2812_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2812());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4 2\n1924", "94"),
                Arguments.of("7 3\n1231234", "3234"),
                Arguments.of("10 4\n4177252841", "775841"),
                Arguments.of("5 1\n54321", "5432"),
                Arguments.of("5 2\n54321", "543"),
                Arguments.of("6 2\n321123", "3223"),
                Arguments.of("5 1\n12345", "2345"),
                Arguments.of("5 2\n12345", "345"),
                Arguments.of("5 3\n12345", "45"),
                Arguments.of("5 4\n12345", "5")

        );
    }
}
