package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_20920_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20920());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 4\n"
                + "apple\n"
                + "ant\n"
                + "sand\n"
                + "apple\n"
                + "append\n"
                + "sand\n"
                + "sand", "sand\n"
                + "apple\n"
                + "append"),
            Arguments.of("12 5\n"
                + "appearance\n"
                + "append\n"
                + "attendance\n"
                + "swim\n"
                + "swift\n"
                + "swift\n"
                + "swift\n"
                + "mouse\n"
                + "wallet\n"
                + "mouse\n"
                + "ice\n"
                + "age", "swift\n"
                + "mouse\n"
                + "appearance\n"
                + "attendance\n"
                + "append\n"
                + "wallet")
        );
    }
}