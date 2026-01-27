package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_11070_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11070());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "2\n3 5\n1 2 3 5\n1 3 10 1\n1 2 0 7\n2 3 9 3\n3 2 4 5\n4 6\n1 2 0 11\n1 3 17 13\n1 4 17 1\n2 3 7 12\n2 4 19 17\n3 4 17 0",
                        "871\n100\n753\n103"));
    }

}
