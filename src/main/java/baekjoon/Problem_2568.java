package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2568 implements ProblemInterface {

    private static class Wire {

        int A;
        int B;

        public Wire(int a, int b) {
            this.A = a;
            this.B = b;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Wire> wires = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires.add(new Wire(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            ));
        }

        wires.sort(Comparator.comparingInt(o -> o.A));
        Wire[] dp = new Wire[N];
        int[] trace = new int[N];
        dp[0] = wires.get(0);
        trace[0] = 0;
        int lastIndex = 1;
        for (int i = 1; i < N; i++) {
            int left = 0;
            int right = lastIndex;

            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid].B > wires.get(i).B) {
                    right = mid;
                    continue;
                }
                left = mid + 1;
            }

            dp[right] = wires.get(i);
            trace[i] = right;
            if (right == lastIndex) {
                lastIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - lastIndex).append("\n");

        List<Integer> removeWires = new ArrayList<>();
        lastIndex--;
        for (int i = N - 1; i >= 0; i--) {
            if (trace[i] == lastIndex) {
                lastIndex--;
                continue;
            }
            removeWires.add(wires.get(i).A);
        }

        removeWires.sort(Comparator.naturalOrder());
        for (int wire : removeWires) {
            sb.append(wire).append("\n");
        }

        System.out.println(sb);
    }
}
