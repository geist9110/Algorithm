package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_5600 implements ProblemInterface {
    private static final int UNKNOWN = 0;
    private static final int NORMAL = 1;
    private static final int BREAKDOWN = -1;

    private static class Part {
        int power;
        int moter;
        int cable;

        public Part(int power, int moter, int cable) {
            this.power = power;
            this.moter = moter;
            this.cable = cable;
        }

    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] states = new int[a + b + c + 1];
        Queue<Part> partsQueue = new LinkedList<>();
        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            Part part = new Part(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            int state = Integer.parseInt(st.nextToken());
            if (state == NORMAL) {
                states[part.power] = NORMAL;
                states[part.moter] = NORMAL;
                states[part.cable] = NORMAL;
                continue;
            }

            partsQueue.add(part);
        }

        while (true) {
            int currentPartCount = partsQueue.size();
            for (int i = 0; i < currentPartCount; i++) {
                Part part = partsQueue.poll();
                if (states[part.power] == NORMAL && states[part.moter] == NORMAL) {
                    states[part.cable] = BREAKDOWN;
                    continue;
                }

                if (states[part.power] == NORMAL && states[part.cable] == NORMAL) {
                    states[part.moter] = BREAKDOWN;
                    continue;
                }

                if (states[part.moter] == NORMAL && states[part.cable] == NORMAL) {
                    states[part.power] = BREAKDOWN;
                    continue;
                }

                partsQueue.add(part);
            }

            if (partsQueue.size() == currentPartCount) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < states.length; i++) {
            if (states[i] == NORMAL) {
                sb.append(1).append("\n");
                continue;
            }

            if (states[i] == BREAKDOWN) {
                sb.append(0).append("\n");
                continue;
            }

            sb.append(2).append("\n");
        }

        System.out.print(sb);
    }

}
