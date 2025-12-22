package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_3933_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3933());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1\n25\n2003\n211\n20007\n0", "1\n3\n48\n7\n738"),
                Arguments.of("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n0", "1\n1\n1\n2\n1\n1\n1\n1\n2\n2"));
    }
}
