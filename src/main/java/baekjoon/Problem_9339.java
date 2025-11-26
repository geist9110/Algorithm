package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_9339 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int K = Integer.parseInt(br.readLine());
            Set<Integer> traineeIndex = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                traineeIndex.add(Integer.parseInt(st.nextToken()));
            }

            int traineeFinishCount = 0;
            int fastestTraineeHour = Integer.MAX_VALUE;
            int fastestTraineeMinutes = Integer.MAX_VALUE;
            int fastestTraineeIndex = 0;
            for (int N = Integer.parseInt(br.readLine()); N > 0; N--) {
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int hour = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());

                if (hour == -1 && minute == -1) {
                    continue;
                }

                if (traineeIndex.contains(index)) {
                    boolean flag = true;

                    if (hour > 6) {
                        flag = false;
                    } else if (hour == 6 && minute > 0) {
                        flag = false;
                    }

                    if (flag) {
                        traineeFinishCount++;
                        if (hour < fastestTraineeHour
                                || (hour == fastestTraineeHour && minute < fastestTraineeMinutes)) {
                            fastestTraineeHour = hour;
                            fastestTraineeMinutes = minute;
                            fastestTraineeIndex = index;
                        }
                    }
                }
            }

            sb.append(fastestTraineeIndex).append(" ").append(traineeFinishCount).append("\n");
        }

        System.out.print(sb);
    }

}
