package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_18222 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        long length = 1;
        while (length <= k) {
            length = length << 1;
        }

        boolean isInverse = false;
        while (k != 1) {
            length = length >> 1;
            if (k > length) {
                k -= length;
                isInverse = !isInverse;
            }
        }

        if (isInverse) {
            System.out.print(1);
            return;
        }
        System.out.print(0);
    }
}
