package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_33963 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int click = 0;
        int length = N.length();

        while (true) {
            N = Long.toString(Long.parseLong(N) * 2);

            if (N.length() > length) {
                break;
            }
            click++;
        }

        System.out.print(click);

    }
}
