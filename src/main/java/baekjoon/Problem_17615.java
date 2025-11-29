package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_17615 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int result = Integer.MAX_VALUE;

        boolean hasPreviousRedBall = false;
        int redBallCount = 0;
        boolean hasPreviousBlueBall = false;
        int blueBallCount = 0;
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);

            if (c == 'R') {
                if (!hasPreviousRedBall) {
                    hasPreviousRedBall = true;
                }

                if (hasPreviousBlueBall) {
                    redBallCount++;
                }
            }

            if (c == 'B') {
                if (!hasPreviousBlueBall) {
                    hasPreviousBlueBall = true;
                }

                if (hasPreviousRedBall) {
                    blueBallCount++;
                }
            }
        }
        result = Math.min(blueBallCount, redBallCount);

        hasPreviousRedBall = false;
        redBallCount = 0;
        hasPreviousBlueBall = false;
        blueBallCount = 0;

        for (int i = N - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == 'R') {
                if (!hasPreviousRedBall) {
                    hasPreviousRedBall = true;
                }

                if (hasPreviousBlueBall) {
                    redBallCount++;
                }
            }

            if (c == 'B') {
                if (!hasPreviousBlueBall) {
                    hasPreviousBlueBall = true;
                }

                if (hasPreviousRedBall) {
                    blueBallCount++;
                }
            }
        }
        result = Math.min(result, Math.min(redBallCount, blueBallCount));

        System.out.println(result);
    }

}
