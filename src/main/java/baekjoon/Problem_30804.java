package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_30804 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tanghulu = new int[N];
        for (int i = 0; i < N; i++) {
            tanghulu[i] = Integer.parseInt(st.nextToken());
        }

        int tanghuluTypeCount = 0;
        int[] tanghuluCount = new int[10];
        int maxLength = 0;

        for (int left = 0, right = 0; right < N; right++) {
            if (tanghuluCount[tanghulu[right]] == 0) {
                tanghuluTypeCount++;
            }

            tanghuluCount[tanghulu[right]]++;

            while (tanghuluTypeCount > 2) {
                tanghuluCount[tanghulu[left]]--;

                if (tanghuluCount[tanghulu[left]] == 0) {
                    tanghuluTypeCount--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        bw.write(String.valueOf(maxLength));
        bw.flush();
    }
}
