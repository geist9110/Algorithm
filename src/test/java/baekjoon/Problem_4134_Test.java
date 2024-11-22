package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_4134_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4134());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n6\n20\n100", "7\n23\n101"),
            Arguments.of("3\n0\n1\n2", "2\n2\n2")
        );
    }
}