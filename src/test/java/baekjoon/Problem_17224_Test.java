package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_17224_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17224());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4 8 4\n1 8\n4 5\n6 20\n9 12", "380"),
                Arguments.of("8 7 5\n1 3\n2 5\n3 5\n4 8\n5 8\n6 9\n6 7\n7 10", "660"),
                Arguments.of("8 9 5\n1 8\n3 10\n4 5\n5 20\n7 12\n8 15\n9 50\n14 14", "580"));
    }
}
