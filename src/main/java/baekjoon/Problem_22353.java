package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_22353 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        double winRate = (double) d / 100;
        double increaseWinRate = 1 + (double) k / 100;
        double loseRateMul = 1;

        double expectTime = 0;
        int passedTime = a;
        while (winRate < 1) {
            expectTime += loseRateMul * winRate * passedTime;
            loseRateMul *= (1 - winRate);
            winRate *= increaseWinRate;
            winRate = Math.min(1, winRate);
            passedTime += a;
        }
        expectTime += loseRateMul * passedTime;

        System.out.print(expectTime);
    }

}
