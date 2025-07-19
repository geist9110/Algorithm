package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_2121 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Point> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            ));
        }

        int result = 0;
        for (Point p : set) {
            Point leftTop = new Point(p.x, p.y + B);
            Point rightTop = new Point(p.x + A, p.y + B);
            Point leftBottom = new Point(p.x + A, p.y);
            if (set.contains(leftTop) && set.contains(rightTop) && set.contains(leftBottom)) {
                result++;
            }
        }

        System.out.print(result);
    }
}
