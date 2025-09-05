package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_20546 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[15];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int junhuynStock = 0;
        int junhuynCache = N;
        for (int i = 0; i < 14; i++) {
            junhuynStock += junhuynCache / array[i];
            junhuynCache %= array[i];
        }

        int sungminStock = 0;
        int sungminCache = N;
        for (int i = 3; i < 14; i++) {
            if (array[i - 3] < array[i - 2]
                && array[i - 2] < array[i - 1]
                && array[i - 1] < array[i]) {
                sungminCache += sungminStock * array[i];
                sungminStock = 0;
                continue;
            }

            if (array[i] < array[i - 1]
                && array[i - 1] < array[i - 2]
                && array[i - 2] < array[i - 3]) {
                sungminStock += sungminCache / array[i];
                sungminCache %= array[i];
            }
        }

        int junhyunResult = junhuynStock * array[13] + junhuynCache;
        int sungminResult = sungminStock * array[13] + sungminCache;

        if (junhyunResult > sungminResult) {
            System.out.print("BNP");
            return;
        }

        if (junhyunResult < sungminResult) {
            System.out.print("TIMING");
            return;
        }

        System.out.print("SAMESAME");

    }
}
