package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_24431 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            Map<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map.merge(st.nextToken().substring(L - F), 1, Integer::sum);
            }

            int result = 0;
            for (int count : map.values()) {
                result += count / 2;
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

}
