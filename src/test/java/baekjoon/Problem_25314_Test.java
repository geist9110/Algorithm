package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_25314_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25314());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4", "long int"),
            Arguments.of("20", "long long long long long int"),
            Arguments.of("15", "long long long long int"),
            Arguments.of("100", "long long long long long long long long long long long long long long long long long long long long long long long long long int")
        );
    }
}