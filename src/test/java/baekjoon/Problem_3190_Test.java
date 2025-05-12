package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_3190_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3190());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("6\n3\n3 4\n2 5\n5 3\n3\n3 D\n15 L\n17 D", "9"),
            Arguments.of("10\n4\n1 2\n1 3\n1 4\n1 5\n4\n8 D\n10 D\n11 D\n13 L", "21"),
            Arguments.of("10\n5\n1 5\n1 3\n1 2\n1 6\n1 7\n4\n8 D\n10 D\n11 D\n13 L", "13")
        );
    }
}