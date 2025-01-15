package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_20303_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20303());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("10 6 6\n" + //
                "9 15 4 4 1 5 19 14 20 5\n" + //
                "1 3\n" + //
                "2 5\n" + //
                "4 9\n" + //
                "6 2\n" + //
                "7 8\n" + //
                "6 10", "57"), Arguments.of("5 4 4\n" + //
                        "9 9 9 9 9\n" + //
                        "1 2\n" + //
                        "2 3\n" + //
                        "3 4\n" + //
                        "4 5", "0"));
    }
}
