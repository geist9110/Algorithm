package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_27438_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27438());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1", "666"),
                Arguments.of("2", "1666"),
                Arguments.of("3", "2666"),
                Arguments.of("4", "3666"),
                Arguments.of("5", "4666"),
                Arguments.of("7", "6660"),
                Arguments.of("8", "6661"),
                Arguments.of("9", "6662"),
                Arguments.of("10", "6663"),
                Arguments.of("11", "6664"),
                Arguments.of("12", "6665"),
                Arguments.of("13", "6666"),
                Arguments.of("14", "6667"),
                Arguments.of("15", "6668"),
                Arguments.of("16", "6669"),
                Arguments.of("17", "7666"),
                Arguments.of("18", "8666"),
                Arguments.of("19", "9666"),
                Arguments.of("187", "66666"),
                Arguments.of("500", "166699"));
    }

}
