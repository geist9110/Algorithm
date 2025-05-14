package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_1107 implements ProblemInterface {

    private static LinkedList<Integer> buttons;
    private static int result;
    private static int N;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] brokenButtons = new boolean[10];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brokenButtons[Integer.parseInt(st.nextToken())] = true;
            }
        }

        buttons = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            if (!brokenButtons[i]) {
                buttons.add(i);
            }
        }

        result = Math.abs(N - 100);
        dfs(0, 0);
        System.out.print(result);
    }

    private static void dfs(int depth, int n) {
        if (depth == 6) {
            return;
        }
        int number = n * 10;
        for (int button : buttons) {
            result = Math.min(result, Math.abs(number + button - N) + depth + 1);
            dfs(depth + 1, number + button);
        }
    }
}
