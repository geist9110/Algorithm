package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1759 implements ProblemInterface {

    private static char[] alphabet, result;
    private static int L, C;
    private static int consonantCount, vowelCount;
    private static BufferedWriter bw;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = br.readLine().replaceAll(" ", "").toCharArray();
        result = new char[L];
        Arrays.sort(alphabet);

        dfs(0, 0);
        bw.flush();
    }

    private static void dfs(int depth, int lastIndex) throws IOException {
        if (depth == L) {
            if (consonantCount >= 1 && vowelCount >= 2) {
                bw.write(result);
                bw.newLine();
            }
            return;
        }

        for (int i = lastIndex; i < C; i++) {
            result[depth] = alphabet[i];
            if (isConsonant(result[depth])) {
                consonantCount++;
                dfs(depth + 1, i + 1);
                consonantCount--;
                continue;
            }
            vowelCount++;
            dfs(depth + 1, i + 1);
            vowelCount--;
        }
    }

    private static boolean isConsonant(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

}
