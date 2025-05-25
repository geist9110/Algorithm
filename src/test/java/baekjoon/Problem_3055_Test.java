package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_3055_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3055());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3 3\nD.*\n...\n.S.", "3"),
            Arguments.of("3 3\nD.*\n...\n..S", "KAKTUS"),
            Arguments.of("3 6\nD...*.\n.X.X..\n....S.", "6"),
            Arguments.of("5 4\n.D.*\n....\n..X.\nS.*.\n....", "4"),
            Arguments.of("1 4\nS.D*", "2")
        );
    }
}