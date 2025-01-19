package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_10775_Test extends ProblemTestConfigure {

        @ParameterizedTest
        @MethodSource("testCase")
        protected void test(String input, String actual) throws IOException {
                run(input, actual, new Problem_10775());
        }

        private static Stream<Arguments> testCase() {
                return Stream.of(
                                Arguments.of("4\n3\n4\n1\n1", "2"),
                                Arguments.of("4\n6\n2\n2\n3\n3\n4\n4", "3"),
                                Arguments.of("4\n6\n4\n4\n4\n4\n4\n4", "4"),
                                Arguments.of("4\n6\n1\n1\n1\n1\n1\n1", "1"),
                                Arguments.of("4\n4\n1\n2\n3\n4", "4"),
                                Arguments.of("4\n4\n4\n3\n2\n1", "4"),
                                Arguments.of("4\n4\n2\n1\n4\n3", "4"),
                                Arguments.of("10\n8\n7\n2\n9\n1\n4\n7\n4\n2", "7"),
                                Arguments.of("4\n4\n4\n3\n1\n1", "3"),
                                Arguments.of("4\n8\n1\n1\n2\n2\n3\n3\n4\n4", "1"),
                                Arguments.of("3\n3\n1\n1\n1", "1"),
                                Arguments.of("3\n3\n1\n2\n3", "3"),
                                Arguments.of("5\n5\n5\n4\n3\n2\n1", "5"),
                                Arguments.of("1\n1\n1", "1"),
                                Arguments.of("20\n20\n7\n12\n1\n14\n5\n6\n15\n20\n10\n4\n9\n8\n3\n13\n2\n11\n17\n19\n16\n18",
                                                "20"),
                                Arguments.of("20\n20\n15\n14\n13\n12\n11\n10\n9\n15\n15\n15\n15\n15\n15\n6\n1\n16\n17\n15\n15\n15",
                                                "17"));
        }
}
