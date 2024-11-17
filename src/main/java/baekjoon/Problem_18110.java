package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_18110 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int trimPerson = Math.round(n * 0.15f);
        int[] levelArray = new int[31];

        for (int i = 0; i < n; i++) {
            levelArray[Integer.parseInt(br.readLine())]++;
        }

        int index = 0;
        int trimCount = 0;
        while (trimCount < trimPerson) {
            if (levelArray[index] == 0) {
                index++;
                continue;
            }
            levelArray[index]--;
            trimCount++;
        }

        index = 30;
        trimCount = 0;
        while (trimCount < trimPerson) {
            if (levelArray[index] == 0) {
                index--;
                continue;
            }
            levelArray[index]--;
            trimCount++;
        }

        double sum = 0;
        double count = 0;
        for (int i = 0; i < levelArray.length; i++) {
            sum += levelArray[i] * i;
            count += levelArray[i];
        }
        System.out.print(Math.round(sum / count));
    }
}
