package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15654 implements ProblemInterface {

    private static int[] array, sequence;
    private static boolean[] visit;
    private static StringBuilder sb;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[N];
        visit = new boolean[N];
        sequence = new int[M];
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == sequence.length) {
            for (int i : sequence) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                sequence[depth] = array[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
