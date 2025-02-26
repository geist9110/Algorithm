package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1475_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1475());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("9999", "2"),
                Arguments.of("122", "2"),
                Arguments.of("12635", "1"),
                Arguments.of("888888", "6"),
                Arguments.of("12399", "1")

        );
    }
}
