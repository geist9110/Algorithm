package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1072 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = 100 * Y / X;

        if(Z >= 99){
            System.out.print(-1);
            return;
        }

        long left = 0;
        long right = X + Y;
        while (left < right) {
            long mid = (left + right) / 2;
            long afterZ = (100 * (Y + mid)) / (X + mid);
            if (afterZ <= Z) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }

        System.out.print(right);
    }
}
