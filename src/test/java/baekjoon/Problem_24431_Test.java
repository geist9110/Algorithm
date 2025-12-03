package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_24431_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_24431());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "5\n4 4 2\nWALK TALK MILK BULK\n4 4 3\nWALK TALK MILK BULK\n4 4 4\nWALK TALK MILK BULK\n6 3 1\nAXB BCC DEE XBB YCC ZEE\n6 3 2\nAXB BCC DEE XBB YCC ZEE",
                        "2\n1\n0\n3\n2"),
                Arguments.of("1\n3 4 2\nABDD ACDK CDAA", "0"));
    }

}
