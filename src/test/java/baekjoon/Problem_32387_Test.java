package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_32387_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_32387());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("""
                        2 11
                        1 2
                        1 2
                        1 1
                        2 1
                        2 2
                        1 1
                        1 1
                        1 1
                        2 1
                        1 2
                        1 1""", """
                        2
                        -1
                        1
                        3
                        1
                        1
                        2
                        -1
                        6
                        -1
                        1"""),
                Arguments.of("""
                        6 13
                        1 3
                        1 5
                        1 3
                        1 3
                        1 3
                        1 1
                        1 6
                        2 5
                        2 6
                        1 2
                        1 1
                        1 1
                        1 1""",
                        """
                                3
                                5
                                4
                                6
                                -1
                                1
                                -1
                                2
                                4
                                2
                                5
                                6
                                -1"""));
    }

}
