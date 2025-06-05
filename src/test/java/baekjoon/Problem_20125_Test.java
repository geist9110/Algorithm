package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_20125_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20125());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5\n"
                    + "_____\n"
                    + "__*__\n"
                    + "_***_\n"
                    + "__*__\n"
                    + "_*_*_", "3 3\n"
                    + "1 1 1 1 1"
            ),
            Arguments.of(
                "10\n"
                    + "__________\n"
                    + "_____*____\n"
                    + "__******__\n"
                    + "_____*____\n"
                    + "_____*____\n"
                    + "_____*____\n"
                    + "____*_*___\n"
                    + "____*_____\n"
                    + "____*_____\n"
                    + "____*_____", "3 6\n"
                    + "3 2 3 4 1"
            ),
            Arguments.of(
                "9\n"
                    + "____*____\n"
                    + "*********\n"
                    + "____*____\n"
                    + "____*____\n"
                    + "____*____\n"
                    + "___*_*___\n"
                    + "___*_*___\n"
                    + "___*_*___\n"
                    + "___*_*___", "2 5\n"
                    + "4 4 3 4 4"
            )
        );
    }
}