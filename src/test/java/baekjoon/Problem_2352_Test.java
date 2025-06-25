package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2352_Test extends ProblemTestConfigure {

  @ParameterizedTest
  @MethodSource("testCase")
  protected void test(String input, String actual) throws IOException {
    run(input, actual, new Problem_2352());
  }

  private static Stream<Arguments> testCase() {
    return Stream.of(Arguments.of("6\n4 2 6 3 1 5", "3"));
  }
}
