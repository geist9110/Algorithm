package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_10164_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10164());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 5 8", "9"),
                Arguments.of("7 11 0", "8008"),
                Arguments.of("7 11 76", "5005"),
                Arguments.of("5 5 20", "35"),
                Arguments.of("2 2 2", "1"),
                Arguments.of("2 2 3", "1"),
                Arguments.of("4 4 3", "4")

        );
    }
}
