package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2936 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double S = 31250.0;

        if (y1 == 0) {
            double y2 = S / x1;
            if (y2 <= 250) {
                System.out.printf("%.2f %.2f", 0d, y2);
                return;
            }

            y2 = S / (250 - x1);
            System.out.printf("%.2f %.2f", 250 - y2, y2);
            return;
        }

        if (x1 == 0) {
            double x2 = S / y1;

            if (x2 <= 250) {
                System.out.printf("%.2f %.2f", x2, 0d);
                return;
            }

            x2 = S / (250 - y1);
            System.out.printf("%.2f %.2f", x2, 250 - x2);
            return;
        }

        if (x1 <= 125) {
            System.out.printf("%.2f %.2f", 250 - S / y1, 0d);
            return;
        }

        System.out.printf("%.2f %.2f", 0d, 250 - S / x1);
    }
}
