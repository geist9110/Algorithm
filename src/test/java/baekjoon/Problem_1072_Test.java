package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1072_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1072());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("10 8", "1"),
            Arguments.of("100 80", "6"),
            Arguments.of("47 47", "-1"),
            Arguments.of("99000 0", "1000"),
            Arguments.of("1000000000 470000000", "19230770"),
            Arguments.of("1000000000 290000000", "14285715"),
            Arguments.of("69 35", "1"),
            Arguments.of("998 144", "7"),
            Arguments.of("1 0", "1")
        );
    }
}