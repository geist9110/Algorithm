package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1469 implements ProblemInterface {

    private static int[] soom;
    private static int[] numbers;
    private static int[] visited;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        soom = new int[2 * N];
        Arrays.fill(soom, -1);
        visited = new int[17];

        if (!dfs(0)) {
            bw.write("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int num : soom) {
                sb.append(num).append(" ");
            }
            bw.write(sb.toString());
        }
        bw.flush();
    }

    private static boolean dfs(int index) {
        if (index == soom.length) {
            return true;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[numbers[i]] > 1) {
                continue;
            }

            if (visited[numbers[i]] == 1) {
                int prevIndex = index - numbers[i] - 1;
                if (prevIndex < 0 || soom[prevIndex] != numbers[i]) {
                    continue;
                }
            }

            visited[numbers[i]]++;
            soom[index] = numbers[i];

            if (dfs(index + 1)) {
                return true;
            }

            visited[numbers[i]]--;
            soom[index] = -1;
        }

        return false;
    }

}
