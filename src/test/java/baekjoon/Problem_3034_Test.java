package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_3034_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3034());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 3 4\n3\n4\n5\n6\n7", "DA\nDA\nDA\nNE\nNE"),
            Arguments.of("2 12 17\n21\n20", "NE\nDA")
        );
    }
}