package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_27438 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        for (int prefix = 0;; prefix++) {
            int from;
            int to;

            if (contains666(prefix)) {
                from = 0;
                to = 999;
            } else if (prefix % 100 == 66) {
                from = 600;
                to = 699;
            } else if (prefix % 10 == 6) {
                from = 660;
                to = 669;
            } else {
                from = 666;
                to = 666;
            }

            for (int surfix = from; surfix <= to; surfix++) {
                N--;
                if (N == 0) {
                    System.out.println((prefix * 1000 + surfix));
                    return;
                }
            }
        }
    }

    private static boolean contains666(long num) {
        while (num >= 666) {
            if (num % 1000 == 666) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

}
