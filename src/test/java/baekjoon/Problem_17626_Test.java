package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17626_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17626());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("25", "1"),
            Arguments.of("26", "2"),
            Arguments.of("11339", "3"),
            Arguments.of("34567", "4")
        );
    }
}