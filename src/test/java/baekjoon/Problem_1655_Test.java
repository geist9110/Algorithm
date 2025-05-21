package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1655_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1655());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7\n1\n5\n2\n10\n-99\n7\n5", "1\n1\n2\n2\n2\n2\n5"),
            Arguments.of("5\n1\n2\n3\n4\n5", "1\n1\n2\n2\n3"),
            Arguments.of("4\n1\n5\n4\n3", "1\n1\n4\n3")
        );
    }
}