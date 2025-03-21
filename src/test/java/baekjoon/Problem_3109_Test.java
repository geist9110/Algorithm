package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_3109_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3109());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5 5\n" + //
                        ".xx..\n" + //
                        "..x..\n" + //
                        ".....\n" + //
                        "...x.\n" + //
                        "...x.", "2"),
                Arguments.of("6 10\n" + //
                        "..x.......\n" + //
                        ".....x....\n" + //
                        ".x....x...\n" + //
                        "...x...xx.\n" + //
                        "..........\n" + //
                        "....x.....",
                        "5"));
    }
}
