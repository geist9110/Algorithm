package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_22994 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ni = Integer.parseInt(st.nextToken());
        int mj = Integer.parseInt(st.nextToken());
        String[] s = new String[ni];
        for (int i = 0; i < ni; i++) {
            s[i] = br.readLine();
        }

        int colGcd = 0;
        for (int row = 0; row < ni; row++) {
            int currentChar = s[row].charAt(0);
            int charCount = 0;
            for (int col = 0; col < mj; col++) {
                if (s[row].charAt(col) == currentChar) {
                    charCount++;
                    continue;
                }
                colGcd = gcd(charCount, colGcd);
                currentChar = s[row].charAt(col);
                charCount = 1;
            }
            colGcd = gcd(charCount, colGcd);
        }

        int rowGcd = 0;
        for (int col = 0; col < mj; col++) {
            int currentChar = s[0].charAt(col);
            int charCount = 0;
            for (int row = 0; row < ni; row++) {
                if (s[row].charAt(col) == currentChar) {
                    charCount++;
                    continue;
                }

                rowGcd = gcd(charCount, rowGcd);
                currentChar = s[row].charAt(col);
                charCount = 1;
            }
            rowGcd = gcd(charCount, rowGcd);
        }

        sb.append(ni / rowGcd).append(" ").append(mj / colGcd).append("\n");
        for (int row = 0; row < ni; row += rowGcd) {
            for (int col = 0; col < mj; col += colGcd) {
                sb.append(s[row].charAt(col));
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
