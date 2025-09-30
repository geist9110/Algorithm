package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16721 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        char[] graph = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = st.nextToken().charAt(0);
        }

        for (int i = 1; i < n; i++) {
            br.readLine();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b == 0) {
                sb.append(graph[c]).append("\n");
                continue;
            }

            if(c == 0) {
                sb.append(graph[b]).append("\n");
                continue;
            }

            if(graph[b] == graph[c]) {
                sb.append("+\n");
                continue;
            }

            sb.append("-\n");
        }

        System.out.print(sb);
    }
}
