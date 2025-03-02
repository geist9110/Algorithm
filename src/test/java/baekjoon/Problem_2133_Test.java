package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2133_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2133());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1", "0"),
                Arguments.of("2", "3"),
                Arguments.of("3", "0"),
                Arguments.of("4", "11"),
                Arguments.of("5", "0"),
                Arguments.of("6", "41"),
                Arguments.of("7", "0"),
                Arguments.of("8", "153"),
                Arguments.of("9", "0"),
                Arguments.of("10", "571"),
                Arguments.of("30", "299303201")

        );
    }
}
