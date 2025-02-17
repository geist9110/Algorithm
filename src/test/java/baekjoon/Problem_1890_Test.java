package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1890_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1890());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "4\n" + //
                                "2 3 3 1\n" + //
                                "1 2 1 3\n" + //
                                "1 2 3 1\n" + //
                                "3 1 1 0",
                        "3"));
    }
}
