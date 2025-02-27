package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1789_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1789());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("200", "19"),
                Arguments.of("190", "19"),
                Arguments.of("209", "19"),
                Arguments.of("1", "1"),
                Arguments.of("2", "1"),
                Arguments.of("5", "2")

        );
    }
}
