package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_9328_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9328());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "5 17\n"
                + "*****************\n"
                + ".............**$*\n"
                + "*B*A*P*C**X*Y*.X.\n"
                + "*y*x*a*p**$*$**$*\n"
                + "*****************\n"
                + "cz\n"
                + "5 11\n"
                + "*.*********\n"
                + "*...*...*x*\n"
                + "*X*.*.*.*.*\n"
                + "*$*...*...*\n"
                + "***********\n"
                + "0\n"
                + "7 7\n"
                + "*ABCDE*\n"
                + "X.....F\n"
                + "W.$$$.G\n"
                + "V.$$$.H\n"
                + "U.$$$.J\n"
                + "T.....K\n"
                + "*SQPML*\n"
                + "irony", "3\n1\n0")
        );
    }
}