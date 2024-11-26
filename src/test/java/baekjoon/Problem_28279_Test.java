package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_28279_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_28279());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("11\n6\n1 3\n1 8\n7\n8\n3\n2 5\n1 2\n5\n4\n4", "1\n8\n3\n8\n3\n5\n3")
        );
    }
}