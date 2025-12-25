package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_31824_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_31824());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 1\nABC X\nA Y\nCDE Z\nABCDE", "YXZ"),
                Arguments.of(
                        "3 3\nKPSC WELCOME\nKOOK HELLOWORLD\nKOOKMIN FIGHTING\nKPSCWELCOME\nCONTEXT\nKOOKMINUNIVERSITY",
                        "WELCOME\n-1\nHELLOWORLDFIGHTING"));
    }

}
