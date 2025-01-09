package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_27172_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27172());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("3\n3 4 12", "1 1 -2"),
                Arguments.of("4\n7 23 8 6", "0 0 0 0"));
    }
}
