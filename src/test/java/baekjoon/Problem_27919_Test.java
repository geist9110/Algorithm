package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_27919_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27919());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("UDPC", "UDP"),
            Arguments.of("UDP", "DP"),
            Arguments.of("UUCCDDDDPPPP", "DP"),
            Arguments.of("UUCCDDDPPPP", "DP"),
            Arguments.of("CCCCCCCCCCCCCCCCDP", "UDP"),
            Arguments.of("UUUDDDD", "UDP"),
            Arguments.of("UUDDDD", "DP")
        );
    }
}