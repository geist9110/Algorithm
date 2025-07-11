package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_15803_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15803());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("1 1\n1 2\n2 1", "WINNER WINNER CHICKEN DINNER!"),
                Arguments.of("12 10\n24 20\n36 30", "WHERE IS MY CHICKEN?"),
                        Arguments.of("1 1\n1 2\n1 3", "WHERE IS MY CHICKEN?"));
    }
}
