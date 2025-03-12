package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1439_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1439());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("0001100", "1"),
                Arguments.of("11111", "0"),
                Arguments.of("00000001", "1"),
                Arguments.of("11001100110011000001", "4"),
                Arguments.of("11101101", "2"));
    }
}
