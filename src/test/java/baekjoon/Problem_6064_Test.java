package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_6064_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_6064());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n10 12 3 9\n10 12 7 2\n13 11 5 6", "33\n-1\n83"),
            Arguments.of("1\n1 1 1 1", "1"),
            Arguments.of("1\n40000 40000 1 1", "1"),
            Arguments.of("1\n40000 40000 40000 40000", "40000")
        );
    }
}