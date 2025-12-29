package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_12924 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int length = String.valueOf(A).length();
        int mul = (int) Math.pow(10, length - 1);
        int[] counted = new int[length];

        int result = 0;
        for (int i = A; i <= B; i++) {
            int current = i;
            int count = 0;

            for (int j = 1; j < length; j++) {
                current = current / 10 + (current % 10) * mul;

                if (current > i && current <= B) {
                    boolean isCounted = false;
                    for (int k = 0; k < count; k++) {
                        if (counted[k] == current) {
                            isCounted = true;
                            break;
                        }
                    }

                    if (!isCounted) {
                        counted[count++] = current;
                    }
                }
            }
            result += count;
        }

        System.out.print(result);
    }

}
