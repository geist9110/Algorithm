package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11000_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11000());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n1 3\n2 4\n3 5", "2"),
                Arguments.of(
                        "10\n42 97\n14 15\n22 39\n51 63\n11 45\n31 60\n30 93\n16 73\n4 95\n22 93",
                        "7"),
                Arguments.of("6\n1 10\n2 3\n2 3\n2 3\n2 3\n3 4", "5"));
    }
}
