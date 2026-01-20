package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_26147_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_26147());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                // Arguments.of("4\nBBYBB\nBBBGB\nBYBBB\nBYBBB",
                // "RAINY\nLEAST\nFOUND\nMIGHT\nPROBE"),
                Arguments.of("4\nBBYBB\nBBBGB\nBYBBB\nBYBBB", "ABCDE\nFFDFF\nFFFDF\nFCFFF\nFCFFF"),
                Arguments.of("6\nYYYYY\nGYYYY\nGGYYY\nGGGYY\nGGGGY\nGGGGG", "IMPOSSIBLE"),
                // Arguments.of("8\nBBGBB\nGGBBY\nYYBBB\nGGGGG\nBBBGY\nYBGBY\nGBBGB\nBBBBB",
                // "SPEED\nCLEAR\nSPARE\nEERIE\nSPEED\nAGREE\nEVENS\nSALES\nWITCH"),
                Arguments.of("8\nBBGBB\nGGBBY\nYYBBB\nGGGGG\nBBBGY\nYBGBY\nGBBGB\nBBBBB",
                        "ABCDE\nFFCFF\nABFFC\nBCFFF\nABCDE\nFFFDA\nBFCFA\nAFFDF\nFFFFF"),

                Arguments.of("1\nYYYYY", "ABCDE\nBCDEA"));
    }

}
