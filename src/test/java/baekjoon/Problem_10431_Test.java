package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10431_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10431());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n"
                    + "1 900 901 902 903 904 905 906 907 908 909 910 911 912 913 914 915 916 917 918 919\n"
                    + "2 919 918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900\n"
                    + "3 901 902 903 904 905 906 907 908 909 910 911 912 913 914 915 916 917 918 919 900\n"
                    + "4 918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900 919",
                "1 0\n2 190\n3 19\n4 171")
        );
    }
}