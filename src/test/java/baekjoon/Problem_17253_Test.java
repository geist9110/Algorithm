package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17253_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17253());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("109", "YES"),
            Arguments.of("298", "NO"),
            Arguments.of("7", "NO"),
            Arguments.of("18", "NO"),
            Arguments.of("0", "NO"),
            Arguments.of("1", "YES"),
            Arguments.of("3", "YES"),
            Arguments.of("4", "YES"),
            Arguments.of("9", "YES"),
            Arguments.of("10", "YES"),
            Arguments.of("12", "YES"),
            Arguments.of("13", "YES"),
            Arguments.of("27", "YES"),
            Arguments.of("28", "YES"),
            Arguments.of("30", "YES"),
            Arguments.of("31", "YES"),
            Arguments.of("36", "YES"),
            Arguments.of("37", "YES"),
            Arguments.of("39", "YES"),
            Arguments.of("40", "YES")
        );
    }
}