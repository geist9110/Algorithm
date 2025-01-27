package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_10826_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10826());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("10", "55"),
                Arguments.of("0", "0"),
                Arguments.of("1", "1"),
                Arguments.of("2", "1"),
                Arguments.of("3", "2"),
                Arguments.of("4", "3"),
                Arguments.of("5", "5"),
                Arguments.of("6", "8"),
                Arguments.of("7", "13"),
                Arguments.of("8", "21"),
                Arguments.of("9", "34"),
                Arguments.of("11", "89"),
                Arguments.of("12", "144"),
                Arguments.of("13", "233"),
                Arguments.of("14", "377"),
                Arguments.of("15", "610"),
                Arguments.of("16", "987"),
                Arguments.of("17", "1597"),
                Arguments.of("1000",
                        "43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875"));
    }
}
