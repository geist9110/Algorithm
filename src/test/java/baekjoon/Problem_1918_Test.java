package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1918_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1918());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("A*(B+C)", "ABC+*"),
            Arguments.of("A+B", "AB+"),
            Arguments.of("A+B*C", "ABC*+"),
            Arguments.of("A+B*C-D/E", "ABC*+DE/-"),
            Arguments.of("A*B+C", "AB*C+"),
            Arguments.of("(A*B)+C", "AB*C+"),
            Arguments.of("(A+B)*C", "AB+C*"),
            Arguments.of("(A+B*C)", "ABC*+"),
            Arguments.of("A*(B+C)*D", "ABC+*D*")
        );
    }
}