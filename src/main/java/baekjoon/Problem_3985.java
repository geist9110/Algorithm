package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3985 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] cake = new int[L + 1];

        int expectedAudienceIndex = 0;
        int expectedAudienceSlice = 0;

        int actualAudienceIndex = 0;
        int actualAudienceSlice = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int expectedSlice = K - P + 1;

            if (expectedSlice > expectedAudienceSlice) {
                expectedAudienceIndex = i;
                expectedAudienceSlice = expectedSlice;
            }

            int actualSlice = 0;
            for (int j = P; j <= K; j++) {
                if (cake[j] != 0) {
                    continue;
                }
                cake[j] = i;
                actualSlice++;
            }

            if (actualSlice > actualAudienceSlice) {
                actualAudienceIndex = i;
                actualAudienceSlice = actualSlice;
            }
        }

        System.out.printf("%d\n%d", expectedAudienceIndex, actualAudienceIndex);
    }
}
