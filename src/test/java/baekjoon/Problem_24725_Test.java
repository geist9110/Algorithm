package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_24725_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24725());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5 5\nJICDE\nTFSFN\nSESTF\nEWERP\nABCDE", "3"),
                Arguments.of("5 4\nENFP\nENFP\nENFP\nENFP\nENFP", "9"),
                Arguments.of("4 4\nABCE\nDZNP\nSFQA\nPALR", "1"),
                Arguments.of("4 4\nPBCA\nDFNP\nSVNA\nJTSI", "2"),
                Arguments.of("4 4\nIERR\nISFJ\nCTFU\nVJLJ", "3"));
    }
}
