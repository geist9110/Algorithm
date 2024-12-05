package baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5525_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5525());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("1\n13\nOOIOIOIOIIOII", "4"),
            Arguments.of("2\n13\nOOIOIOIOIIOII", "2")
        );
    }
}