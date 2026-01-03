package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2118_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2118());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n1\n2\n3\n4\n5", "7"),
                Arguments.of("10\n1\n1\n1\n1\n1\n10000\n1\n1\n1\n1", "9"),
                Arguments.of("5\n1\n2\n3\n7\n10", "11"),
                Arguments.of("3\n1\n9\n3", "4"),
                Arguments.of("3\n5\n3\n6", "6"),
                Arguments.of("4\n5\n7\n5\n9", "12"),
                Arguments.of("6\n30\n86\n90\n48\n13\n53", "151"));
    }

}
