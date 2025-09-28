package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10774 implements ProblemInterface {

    private static char SELECTED = 'X';

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int J = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());

        char[] jacketSizes = new char[J + 1];
        for (int i = 1; i <= J; i++) {
            jacketSizes[i] = br.readLine().charAt(0);
        }

        int count = 0;
        for (int i = 0; i < A; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char size = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());

            if(canWear(jacketSizes[number], size)) {
                jacketSizes[number] = SELECTED;
                count++;
            }
        }

        System.out.print(count);
    }

    private static boolean canWear(char jacketSize, char wantSize) {
        if (jacketSize == SELECTED) {
            return false;
        }

        if (jacketSize == 'L') {
            return true;
        }

        if (jacketSize == 'M' && wantSize != 'L') {
            return true;
        }

        return jacketSize == 'S' && wantSize == 'S';
    }
}
