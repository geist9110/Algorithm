package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1431_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1431());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\nABCD\n145C\nA\nA910\nZ321", "A\nABCD\nZ321\n145C\nA910"),
                Arguments.of("2\nZ19\nZ20", "Z20\nZ19"),
                Arguments.of(
                        "4\n34H2BJS6N\nPIM12MD7RCOLWW09\nPYF1J14TF\nFIPJOTEA5",
                        "FIPJOTEA5\nPYF1J14TF\n34H2BJS6N\nPIM12MD7RCOLWW09"),
                Arguments.of("5\nABCDE\nBCDEF\nABCDA\nBAAAA\nACAAA", "ABCDA\nABCDE\nACAAA\nBAAAA\nBCDEF"),
                Arguments.of("2\n10\nA1", "10\nA1"),
                Arguments.of("3\n3501\n0E013\n0A3E1", "3501\n0A3E1\n0E013"),
                Arguments.of("3\nD\nAE\nA0", "D\nA0\nAE"),
                Arguments.of("5\nD\n10\nCEE\nCCB\n50A", "D\n10\nCCB\nCEE\n50A"));
    }

}
