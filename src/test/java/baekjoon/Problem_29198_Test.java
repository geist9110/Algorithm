package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Problem_29198_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_29198());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 1 2\nY\nY\nZ\nX", "XY"),
            Arguments.of("3 4 2\nABCD\nAACC\nABCC", "AAABCCCC"));
    }
}