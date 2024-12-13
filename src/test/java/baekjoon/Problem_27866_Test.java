package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_27866_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27866());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("Sprout\n3", "r"),
            Arguments.of("shiftpsh\n6", "p"),
            Arguments.of("Baekjoon\n4", "k"),
            Arguments.of("a\n1", "a")
        );
    }
}