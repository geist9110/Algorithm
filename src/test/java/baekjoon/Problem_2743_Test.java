package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2743_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2743());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("pulljima", "8"),
            Arguments.of("baekjoon", "8"),
            Arguments.of("HelloWorld", "10")
        );
    }
}