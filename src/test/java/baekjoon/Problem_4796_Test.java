package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_4796_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4796());
    }

    private static Stream<Arguments> testCase() {
        return Stream
                .of(Arguments.of("5 8 20\n" + "5 8 17\n" + "0 0 0", "Case 1: 14\n" + "Case 2: 11"));
    }
}
