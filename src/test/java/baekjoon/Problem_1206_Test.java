package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1206_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1206());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n0.500\n0.250\n0.125", "8"),
                Arguments.of("1\n0.000", "1"),
                Arguments.of("2\n0.500\n0.300", "10"),
                Arguments.of("2\n0.500\n0.301", "106"),
                Arguments.of("3\n4.864\n5.027\n5.000", "37"),
                Arguments.of(
                        "40\n1.234\n3.554\n6.771\n2.334\n9.112\n3.414\n5.666\n1.222\n7.123\n7.854\n1.231\n3.552\n6.773\n2.334\n9.115\n3.416\n5.667\n1.228\n7.129\n7.851\n1.239\n3.558\n6.776\n2.335\n9.114\n3.413\n5.662\n9.221\n7.120\n8.858\n9.999\n0.001\n9.998\n9.997\n9.996\n9.995\n9.994\n9.553\n9.993\n9.992",
                        "1000"),
                Arguments.of("1\n0.001", "501"));
    }

}
