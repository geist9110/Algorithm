package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_16724_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16724());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("3 4\n" + //
                "DLLL\n" + //
                "DRLU\n" + //
                "RRRU", "2"), Arguments.of("3 3\n" + //
                        "RRD\n" + //
                        "UDD\n" + //
                        "RLL", "1"),
                Arguments.of("2 2\n" + //
                        "DL\n" + //
                        "UU", "1"));
    }

}
