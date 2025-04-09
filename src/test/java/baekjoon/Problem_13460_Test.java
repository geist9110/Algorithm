package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_13460_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_13460());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 5\n"
                + "#####\n"
                + "#..B#\n"
                + "#.#.#\n"
                + "#RO.#\n"
                + "#####", "1"),
            Arguments.of("7 7\n"
                + "#######\n"
                + "#...RB#\n"
                + "#.#####\n"
                + "#.....#\n"
                + "#####.#\n"
                + "#O....#\n"
                + "#######", "5"),
            Arguments.of("7 7\n"
                + "#######\n"
                + "#...RB#\n"
                + "#.#####\n"
                + "#.....#\n"
                + "#####.#\n"
                + "#O....#\n"
                + "#######", "5"),
            Arguments.of("10 10\n"
                + "##########\n"
                + "#R#...##B#\n"
                + "#...#.##.#\n"
                + "#####.##.#\n"
                + "#......#.#\n"
                + "#.######.#\n"
                + "#.#....#.#\n"
                + "#.#.#.#..#\n"
                + "#...#.O#.#\n"
                + "##########", "-1"),
            Arguments.of("3 7\n"
                + "#######\n"
                + "#R.O.B#\n"
                + "#######", "1"),
            Arguments.of("3 10\n"
                + "##########\n"
                + "#.O....RB#\n"
                + "##########", "-1"),
            Arguments.of("15 4\n"
                + "####\n"
                + "#B##\n"
                + "####\n"
                + "#R.#\n"
                + "##.#\n"
                + "#..#\n"
                + "#.##\n"
                + "#..#\n"
                + "##.#\n"
                + "#..#\n"
                + "#.##\n"
                + "#..#\n"
                + "##.#\n"
                + "#.O#\n"
                + "####", "10"),
            Arguments.of("10 10\n"
                + "##########\n"
                + "#R#...##B#\n"
                + "#...#.####\n"
                + "#####....#\n"
                + "########.#\n"
                + "########.#\n"
                + "#O.....#.#\n"
                + "######.#.#\n"
                + "######...#\n"
                + "##########", "10"),
            Arguments.of("10 10\n"
                + "##########\n"
                + "#R#...##B#\n"
                + "#...#.##.#\n"
                + "#####.##.#\n"
                + "#......#.#\n"
                + "#.######.#\n"
                + "#.#....#.#\n"
                + "#.#.##...#\n"
                + "#O..#....#\n"
                + "##########", "7"),
            Arguments.of("8 8\n"
                + "########\n"
                + "#BR.#.O#\n"
                + "###.#..#\n"
                + "#...#..#\n"
                + "#.###..#\n"
                + "#..#..##\n"
                + "##...#.#\n"
                + "########", "-1"),
            Arguments.of("6 6\n"
                + "######\n"
                + "#..#.#\n"
                + "#....#\n"
                + "#O#..#\n"
                + "#B..R#\n"
                + "######", "8")
        );
    }
}