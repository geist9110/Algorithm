package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1461 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> positiveLocation = new ArrayList<>();
        positiveLocation.add(0);
        List<Integer> negativeLocation = new ArrayList<>();
        negativeLocation.add(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int nextLocation = Integer.parseInt(st.nextToken());
            if (nextLocation > 0) {
                positiveLocation.add(nextLocation);
                continue;
            }

            negativeLocation.add(-nextLocation);
        }

        positiveLocation.sort(Comparator.naturalOrder());
        negativeLocation.sort(Comparator.naturalOrder());

        int result = 0;

        for (int i = (positiveLocation.size() - 1) % M; i < positiveLocation.size(); i += M) {
            result += positiveLocation.get(i) * 2;
        }

        for (int i = (negativeLocation.size() - 1) % M; i < negativeLocation.size(); i += M) {
            result += negativeLocation.get(i) * 2;
        }

        result -= Math.max(positiveLocation.get(positiveLocation.size() - 1),
            negativeLocation.get(negativeLocation.size() - 1));

        System.out.print(result);
    }
}
