package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_19843_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_19843());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "56 6\nMon 22 Tue 2\nTue 15 Tue 19\nTue 19 Wed 4\nWed 17 Thu 1\nThu 12 Thu 17\nFri 4 Fri 12",
                        "18"),
                Arguments.of("50 5\nMon 0 Mon 11\nTue 2 Tue 12\nWed 0 Wed 10\nThu 3 Thu 15\nFri 11 Fri 23", "0"),
                Arguments.of("120 5\nMon 0 Mon 11\nTue 2 Tue 12\nWed 0 Wed 10\nThu 3 Thu 15\nFri 11 Fri 23", "-1"));
    }
}
