package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_31831 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalStress = 0;
        int stomachAcheCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            totalStress += Integer.parseInt(st.nextToken());
            totalStress = Math.max(totalStress, 0);
            if (totalStress >= M) {
                stomachAcheCount++;
            }
        }

        System.out.print(stomachAcheCount);
    }
}
