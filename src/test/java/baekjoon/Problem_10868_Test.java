package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10868_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10868());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "10 4\n"
                    + "75\n"
                    + "30\n"
                    + "100\n"
                    + "38\n"
                    + "50\n"
                    + "51\n"
                    + "52\n"
                    + "20\n"
                    + "81\n"
                    + "5\n"
                    + "1 10\n"
                    + "3 5\n"
                    + "6 9\n"
                    + "8 10",
                "5\n"
                    + "38\n"
                    + "20\n"
                    + "5"
            )
        );
    }
}