package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_1475 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();

        int[] needNumberCount = new int[9];
        for (int i = 0; i < roomNumber.length(); i++) {
            char c = roomNumber.charAt(i);
            if (c == '9') {
                needNumberCount[6]++;
                continue;
            }
            needNumberCount[c - '0']++;
        }

        if (needNumberCount[6] % 2 == 0) {
            needNumberCount[6] /= 2;
        } else {
            needNumberCount[6] = (needNumberCount[6] + 1) / 2;
        }

        int result = 0;
        for (int i = 0; i < 9; i++) {
            result = Math.max(result, needNumberCount[i]);
        }

        System.out.print(result);

    }

}
