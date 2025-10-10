package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1340_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1340(), 1e-9);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("January 01, 2008 00:00", "0.0"),
            Arguments.of("May 10, 1981 00:31", "35.348363774733635"),
            Arguments.of("December 31, 2007 23:59", "99.99980974124807"),
            Arguments.of("July 02, 2007 12:00", "50.0"),
            Arguments.of("July 02, 2008 00:00", "50.0"),
            Arguments.of("January 31, 1900 00:47", "8.228120243531203")
        );
    }
}