package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_24266_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24266());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7", "343\n3"),
            Arguments.of("1", "1\n3"),
            Arguments.of("2", "8\n3"),
            Arguments.of("3", "27\n3"),
            Arguments.of("500000", "125000000000000000\n3")
        );
    }
}