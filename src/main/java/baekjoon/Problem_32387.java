package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

import baekjoon.config.ProblemInterface;

public class Problem_32387 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> availablePort = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            availablePort.add(i);
        }

        int[] action = new int[N + 1];
        for (int q = 1; q <= Q; q++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int i = Integer.parseInt(st.nextToken());

            if (t.equals("1")) {
                Integer portNumber = availablePort.ceiling(i);

                if (portNumber == null) {
                    sb.append("-1\n");
                    continue;
                }

                availablePort.remove(portNumber);
                action[portNumber] = q;
                sb.append(portNumber).append("\n");
                continue;
            }

            if (t.equals("2")) {
                if (availablePort.contains(i)) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(action[i]).append("\n");
                availablePort.add(i);
                continue;
            }

        }

        System.out.print(sb);
    }

}
