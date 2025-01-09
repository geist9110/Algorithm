package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_27172 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] cardNumbers = new int[N];
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            cardNumbers[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, cardNumbers[i]);
        }

        int[] resultArray = new int[maxValue + 1];
        boolean[] isExistArray = new boolean[maxValue + 1];
        for (int cardNumber : cardNumbers) {
            isExistArray[cardNumber] = true;
        }

        for (int cardNumber : cardNumbers) {
            for (int i = cardNumber; i <= maxValue; i += cardNumber) {
                if (isExistArray[i]) {
                    resultArray[cardNumber]++;
                    resultArray[i]--;
                }
            }
        }

        for (int cardNumber : cardNumbers) {
            bw.write(resultArray[cardNumber] + " ");
        }
        bw.flush();
    }

}
