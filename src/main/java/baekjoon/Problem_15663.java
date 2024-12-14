package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15663 implements ProblemInterface {

    private static int N, M;
    private static int[] array, sequence;
    private static boolean[] visit;
    private static StringBuilder sb;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        array = new int[N];

        M = Integer.parseInt(st.nextToken());
        sequence = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i : sequence) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i] || before == array[i]) {
                continue;
            }

            visit[i] = true;
            sequence[depth] = array[i];
            before = array[i];
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}
