package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_29702 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            long N = Long.parseLong(br.readLine());
            long floor = 64 - Long.numberOfLeadingZeros(N);
            long index = N - (1L << (floor - 1)) + 1;

            appendRoomNumber(sb, floor, index);
            while (floor != 1) {
                floor--;
                index = (index + 1) / 2;

                appendRoomNumber(sb, floor, index);
            }
        }

        System.out.print(sb);
    }

    private static void appendRoomNumber(StringBuilder sb, long floor, long index) {
        sb.append(floor);
        String indexString = String.valueOf(index);
        for (int i = 0; i < 18 - indexString.length(); i++) {
            sb.append("0");
        }
        sb.append(indexString).append("\n");
    }

}
