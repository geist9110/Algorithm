package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_14254_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14254());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("bojboj\n3", "0"),
                Arguments.of("loool\n3", "1"),
                Arguments.of("baekjoon\n8", "0"),
                Arguments.of("amavckdkz\n7", "5"));
    }

}
