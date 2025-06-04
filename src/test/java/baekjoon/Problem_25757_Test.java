package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_25757_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25757());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 Y\n"
                + "lms0806\n"
                + "lms0806\n"
                + "exponentiale\n"
                + "lms0806\n"
                + "jthis\n"
                + "lms0806\n"
                + "leo020630", "4"),
            Arguments.of("12 F\n"
                + "lms0806\n"
                + "powergee\n"
                + "skeep194\n"
                + "lms0806\n"
                + "tony9402\n"
                + "lms0806\n"
                + "wider93\n"
                + "lms0806\n"
                + "mageek2guanaah\n"
                + "lms0806\n"
                + "jthis\n"
                + "lms0806", "3"),
            Arguments.of("12 O\n"
                + "lms0806\n"
                + "mageek2guanaah\n"
                + "jthis\n"
                + "lms0806\n"
                + "exponentiale\n"
                + "lms0806\n"
                + "leo020630\n"
                + "lms0806\n"
                + "powergee\n"
                + "lms0806\n"
                + "skeep194\n"
                + "lms0806", "2")
        );
    }
}