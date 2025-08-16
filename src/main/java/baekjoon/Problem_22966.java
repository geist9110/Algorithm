package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_22966 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String minTitle = "";
        int minLevel = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String currentTitle = st.nextToken();
            int currentLevel = Integer.parseInt(st.nextToken());

            if (currentLevel < minLevel) {
                minTitle = currentTitle;
                minLevel = currentLevel;
            }
        }

        System.out.print(minTitle);
    }
}
