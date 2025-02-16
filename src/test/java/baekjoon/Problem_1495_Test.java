package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1495_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1495());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 5 10\n5 3 7", "10"),
                Arguments.of("4 8 20\n15 2 9 10", "-1"),
                Arguments.of("14 40 243\n74 39 127 95 63 140 99 96 154 18 137 162 14 88", "238"));
    }

}
