package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15666 implements ProblemInterface {

    private static int N, M;
    private static int[] array, sequence;
    private static StringBuilder sb;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        array = new int[N];

        M = Integer.parseInt(st.nextToken());
        sequence = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int depth, int prevIndex) {
        if (depth == M) {
            for (int seq : sequence) {
                sb.append(seq).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = prevIndex; i < N; i++) {
            if (array[i] > prev) {
                prev = array[i];
                sequence[depth] = array[i];
                dfs(depth + 1, i);
            }
        }
    }
}
