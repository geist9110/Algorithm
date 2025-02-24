package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2011_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2011());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("25114", "6"),
                Arguments.of("1111111111", "89"),
                Arguments.of("27", "1"),
                Arguments.of("1", "1"),
                Arguments.of("9", "1"),
                Arguments.of("10", "1"),
                Arguments.of("11", "2"),
                Arguments.of("19", "2"),
                Arguments.of("20", "1"),
                Arguments.of("21", "2"),
                Arguments.of("101", "1"),
                Arguments.of("0", "0"),
                Arguments.of("000", "0"),
                Arguments.of("1712279212", "18"),
                Arguments.of("015", "0"),
                Arguments.of("20236", "2"),
                Arguments.of("2727", "1"),
                Arguments.of("111111111111111111111111111111", "346269"),
                Arguments.of("100", "0"),
                Arguments.of("20114", "3"),
                Arguments.of("1131212501112122", "0")

        );
    }

}
