package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1120 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int result = Integer.MAX_VALUE;
        for (int gap = B.length() - A.length(); gap >= 0; gap--) {
            int gapResult = 0;
            for (int index = 0; index < A.length(); index++) {
                if (A.charAt(index) != B.charAt(index + gap)) {
                    gapResult++;
                }
            }
            result = Math.min(result, gapResult);
        }
        System.out.print(result);
    }
}
