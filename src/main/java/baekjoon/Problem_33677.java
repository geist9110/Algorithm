package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_33677 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] date = new int[N + 1];
        int[] water = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            date[i] = i;
            water[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            if (i + 1 <= N) {
                if (date[i] + 1 < date[i + 1]) {
                    date[i + 1] = date[i] + 1;
                    water[i + 1] = water[i] + 1;
                } else if (date[i] + 1 == date[i + 1]) {
                    water[i + 1] = Math.min(water[i + 1], water[i] + 1);
                }
            }

            if ((long) 3 * i <= N) {
                if (date[i] + 1 < date[3 * i]) {
                    date[3 * i] = date[i] + 1;
                    water[3 * i] = water[i] + 3;
                } else if (date[i] + 1 == date[3 * i]) {
                    water[3 * i] = Math.min(water[3 * i], water[i] + 3);
                }
            }

            if ((long) i * i <= N) {
                if (date[i] + 1 < date[i * i]) {
                    date[i * i] = date[i] + 1;
                    water[i * i] = water[i] + 5;
                } else if (date[i] + 1 == date[i * i]) {
                    water[i * i] = Math.min(water[i * i], water[i] + 5);
                }
            }
        }

        System.out.print(date[N] + " " + water[N]);

    }
}
