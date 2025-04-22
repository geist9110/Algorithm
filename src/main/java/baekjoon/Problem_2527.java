package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2527 implements ProblemInterface {

    private static class Square {

        int minX;
        int minY;
        int maxX;
        int maxY;

        public Square(int minX, int minY, int maxX, int maxY) {
            this.minX = Math.min(maxX, minX);
            this.maxX = Math.max(maxX, minX);
            this.minY = Math.min(maxY, minY);
            this.maxY = Math.max(maxY, minY);
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Square firstSquare = new Square(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
            Square secondSquare = new Square(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );

            // 한점에서 만나는 케이스
            if (
                (firstSquare.maxX == secondSquare.minX && firstSquare.maxY == secondSquare.minY)
                    || (firstSquare.maxX == secondSquare.minX
                    && firstSquare.minY == secondSquare.maxY)
                    || (firstSquare.minX == secondSquare.maxX
                    && firstSquare.maxY == secondSquare.minY)
                    || (firstSquare.minX == secondSquare.maxX
                    && firstSquare.minY == secondSquare.maxY)
            ) {
                bw.write('c');
                bw.newLine();
                continue;
            }

            // 만나지 않는 케이스
            if (
                firstSquare.maxX < secondSquare.minX
                    || firstSquare.minX > secondSquare.maxX
                    || firstSquare.maxY < secondSquare.minY
                    || firstSquare.minY > secondSquare.maxY
            ) {
                bw.write('d');
                bw.newLine();
                continue;
            }

            // 선분에서 만나는 케이스
            if (
                firstSquare.maxY == secondSquare.minY
                    || firstSquare.minY == secondSquare.maxY
                    || firstSquare.maxX == secondSquare.minX
                    || firstSquare.minX == secondSquare.maxX
            ) {
                bw.write('b');
                bw.newLine();
                continue;
            }

            bw.write('a');
            bw.newLine();
        }

        bw.flush();
    }
}
