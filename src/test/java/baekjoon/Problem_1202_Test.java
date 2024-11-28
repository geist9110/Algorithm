package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1202_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1202());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 1\n5 10\n100 100\n11", "10"),
            Arguments.of("3 2\n1 65\n5 23\n2 99\n10\n2", "164"),
            Arguments.of("1 1\n1 1\n100000000", "1"),
            Arguments.of("4 2\n4 100\n5 110\n6 90\n7 80\n5\n7", "210")
        );
    }
}