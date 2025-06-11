package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2816 implements ProblemInterface {

    private static final String KBS1 = "KBS1";
    private static final String KBS2 = "KBS2";
    private static final char MOVE_ARROW_DOWN = '1';
    private static final char MOVE_CHANNEL_UP = '4';

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];

        int kbs1Index = -1;
        int kbs2Index = -1;
        for (int i = 0; i < N; i++) {
            channels[i] = br.readLine();

            if (channels[i].equals(KBS1)) {
                kbs1Index = i;
            }

            if (channels[i].equals(KBS2)) {
                kbs2Index = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < kbs1Index; i++) {
            sb.append(MOVE_ARROW_DOWN);
        }
        for (int i = kbs1Index; i > 0; i--) {
            sb.append(MOVE_CHANNEL_UP);
        }

        if (kbs1Index > kbs2Index) {
            kbs2Index++;
        }

        for (int i = 0; i < kbs2Index; i++) {
            sb.append(MOVE_ARROW_DOWN);
        }
        for (int i = kbs2Index; i > 1; i--) {
            sb.append(MOVE_CHANNEL_UP);
        }

        System.out.print(sb);
    }
}
