package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1946 implements ProblemInterface {
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int N = Integer.parseInt(br.readLine());
            int[] interviewScreeningRatings = new int[N + 1];

            for (int volunteerIndex = 1; volunteerIndex <= N; volunteerIndex++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                interviewScreeningRatings[Integer.parseInt(st.nextToken())] =
                        Integer.parseInt(st.nextToken());
            }

            int minInterviewScreening = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 1; i <= N; i++) {
                if (interviewScreeningRatings[i] < minInterviewScreening) {
                    result++;
                    minInterviewScreening = interviewScreeningRatings[i];
                }
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
    }

}
