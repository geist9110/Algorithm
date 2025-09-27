package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_23056_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_23056());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4 2\n"
                    + "3 sunyoung\n"
                    + "2 junkyu\n"
                    + "2 dohyun\n"
                    + "1 minjun\n"
                    + "3 kihyun\n"
                    + "2 damin\n"
                    + "4 hyunsu\n"
                    + "0 0", "1 minjun\n"
                    + "3 kihyun\n"
                    + "3 sunyoung\n"
                    + "2 dohyun\n"
                    + "2 junkyu\n"
                    + "4 hyunsu"
            )
        );
    }
}