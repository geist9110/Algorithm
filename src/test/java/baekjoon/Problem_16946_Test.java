package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_16946_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16946());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 3\n101\n010\n101", "303\n050\n303"),
                Arguments.of("4 5\n11001\n00111\n01010\n10101", "46003\n00732\n06040\n50403"));
    }
}
