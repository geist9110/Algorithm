package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_3020_Test extends ProblemTestConfigure {

  @ParameterizedTest
  @MethodSource("testCase")
  protected void test(String input, String actual) throws IOException {
    run(input, actual, new Problem_3020());
  }

  private static Stream<Arguments> testCase() {
    return Stream.of(Arguments.of("6 7\n1\n5\n3\n3\n5\n1", "2 3"),
        Arguments.of("14 5\n1\n3\n4\n2\n2\n4\n3\n4\n3\n3\n3\n2\n3\n3", "7 2"));
  }
}
