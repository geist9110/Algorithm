package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Problem_1461_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1461());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 2\n-37 2 -6 -39 -29 11 -28", "131"),
            Arguments.of("8 3\n-18 -9 -4 50 22 -26 40 -45", "158"),
            Arguments.of("6 2\n3 4 5 6 11 -1", "29"),
            Arguments.of("1 50\n1", "1"));
    }
}
