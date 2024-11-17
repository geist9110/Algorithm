package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_18110_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_18110());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n1\n5\n5\n7\n8", "6"),
            Arguments.of("10\n1\n13\n12\n15\n3\n16\n13\n12\n14\n15", "13")
        );
    }
}