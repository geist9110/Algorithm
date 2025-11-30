package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_22994_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_22994());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 6\naabbaa\nbbaabb\naabbaa", "3 3\naba\nbab\naba"),
                Arguments.of("1 7\naabbbaa", "1 7\naabbbaa"),
                Arguments.of("1 5\naaaaa", "1 1\na"),
                Arguments.of("4 6\nababab\nababab\ncdcdcd\ncdcdcd", "2 3\naba\ncdc"));
    }

}
