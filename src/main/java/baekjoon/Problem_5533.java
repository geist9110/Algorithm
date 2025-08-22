package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5533 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] selectNumber = new int[N][3];
        for (int person = 0; person < N; person++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int game = 0; game < 3; game++) {
                selectNumber[person][game] = Integer.parseInt(st.nextToken());
            }
        }

        for (int game = 0; game < 3; game++) {
            int[] checker = new int[101];
            for (int person = 0; person < N; person++) {
                int currentNumber = selectNumber[person][game];

                if (checker[currentNumber] == 0) {
                    checker[currentNumber] = -(person + 1);
                    continue;
                }

                selectNumber[person][game] = 0;
                selectNumber[-(checker[currentNumber] + 1)][game] = 0;
            }
        }

        for (int person = 0; person < N; person++) {
            int result = 0;
            for (int game = 0; game < 3; game++) {
                result += selectNumber[person][game];
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
