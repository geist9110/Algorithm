package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10886 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cuteCount = 0;
        int notCuteCount = 0;
        for (int i = 0; i < N; i++) {
            String survey = br.readLine();
            if (survey.equals("1")) {
                cuteCount++;
                continue;
            }
            notCuteCount++;
        }

        if (cuteCount > notCuteCount) {
            System.out.print("Junhee is cute!");
            return;
        }
        System.out.print("Junhee is not cute!");
    }
}
