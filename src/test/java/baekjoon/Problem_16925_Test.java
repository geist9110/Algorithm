package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_16925_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16925());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\nba\na\nabab\na\naba\nbaba\nab\naba", "ababa\nSPPSPSPS"),
                Arguments.of("3\na\naa\naa\na", "aaa\nPPSS"),
                Arguments.of("2\na\nc", "ac\nPS"),
                Arguments.of("4\na\nac\nacc\na\nca\ncca", "acca\nPPPSSS"),
                Arguments.of("3\nba\na\na\nab", "aba\nSPSP"),
                Arguments.of("5\nh\nhe\nhel\nhell\no\nlo\nllo\nello", "hello\nPPPPSSSS"),
                Arguments.of("2\na\na", "aa\nPS"),
                Arguments.of("4\na\nab\nabb\na\nba\nbba", "abba\nPPPSSS"),
                Arguments.of("3\na\nab\na\nba", "aba\nPPSS"),
                Arguments.of("5\na\naa\naaa\naaaa\na\naa\naaa\naaaa", "aaaaa\nPPPPSSSS"),
                Arguments.of("3\nb\nba\nb\nab", "bab\nPPSS"),
                Arguments.of("3\nab\na\nb\naa", "aab\nSPSP"),
                Arguments.of("4\nab\naba\nb\na\nab\nbab", "abab\nPPSPSS"));
    }

}
