package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2485_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2485());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n1\n3\n7\n13", "3"),
            Arguments.of("4\n2\n6\n12\n18", "5")
        );
    }
}