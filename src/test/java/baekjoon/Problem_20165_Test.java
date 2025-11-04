package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_20165_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20165());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
"""
5 5 3
1 1 1 1 1
1 2 2 1 1
3 1 2 2 2
1 3 2 1 1
1 3 3 1 1
3 1 E
3 5
5 3 N
3 3
5 2 N
3 1
""",
"""
11
S F S S S
S F S S S
S F S F S
S F F S S
S F F S S
"""),
                Arguments.of(
"""
3 3 3
3 3 3
3 3 3
3 3 3
1 1 E
1 1
1 2 S
1 2
1 3 S
1 3
""",
"""
3
S S S
S S S
S S S
"""));
    }
}
