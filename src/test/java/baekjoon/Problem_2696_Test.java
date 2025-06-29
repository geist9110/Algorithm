package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2696_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2696());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of(
                "3\n9\n1 2 3 4 5 6 7 8 9\n9\n9 8 7 6 5 4 3 2 1\n23\n23 41 13 22 -3 24 -31 -11 -8 -7\n3 5 103 211 -311 -45 -67 -73 -81 -99\n-33 24 56\n",
                "5\n1 2 3 4 5\n5\n9 8 7 6 5\n12\n23 23 22 22 13 3 5 5 3 -3\n-7 -3\n"));
    }
}
