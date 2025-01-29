package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1788_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1788());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("-2", "-1\n1"),
                Arguments.of("0", "0\n0"),
                Arguments.of("10", "1\n55"),
                Arguments.of("-7", "1\n13"));
    }

}
