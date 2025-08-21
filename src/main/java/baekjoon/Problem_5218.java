package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5218 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            sb.append("Distances:");
            for (int i = 0; i < A.length(); i++) {
                int result = B.charAt(i) - A.charAt(i);
                if (result < 0) {
                    result += 26;
                }
                sb.append(" ").append(result);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
