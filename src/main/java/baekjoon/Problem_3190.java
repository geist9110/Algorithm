package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem_3190 implements ProblemInterface {

    // 우하좌상
    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final char TURN_RIGHT = 'D';
    private static final char TURN_LEFT = 'L';

    private static int N;
    private static Deque<Point> snake;
    private static int direction;
    private static ArrayList<Point> apples;

    private static class Movement {

        int time;
        char direction;

        public Movement(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        apples = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            apples.add(new Point(
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1
            ));
        }

        int L = Integer.parseInt(br.readLine());
        ArrayList<Movement> movements = new ArrayList<>(L);
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            movements.add(new Movement(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        direction = 0;
        int time = 0;
        snake = new ArrayDeque<>();
        snake.add(new Point(0, 0));

        while (true) {
            time++;
            Point nextHead = getNextHead();
            if (isCollapseWall(nextHead) || isCollapseSnake(nextHead)) {
                break;
            }

            if (!isCollapseApple(nextHead)) {
                snake.pollLast();
            }
            snake.addFirst(nextHead);

            if (!movements.isEmpty() && movements.get(0).time == time) {
                turn(movements.get(0).direction);
                movements.remove(0);
            }
        }

        System.out.print(time);
    }

    private static void turn(char nextDirection) {
        if (nextDirection == TURN_RIGHT) {
            direction = (direction + 1) % 4;
            return;
        }

        direction = (direction + 3) % 4;
    }

    private static boolean isCollapseWall(Point head) {
        return head.x < 0 || head.x >= N || head.y < 0 || head.y >= N;
    }

    private static boolean isCollapseSnake(Point head) {
        for (Point body : snake) {
            if (head.x == body.x && head.y == body.y) {
                return true;
            }
        }
        return false;
    }

    private static Point getNextHead() {
        Point head = snake.peekFirst();
        return new Point(head.x + DIRECTION[direction][0], head.y + DIRECTION[direction][1]);
    }

    private static boolean isCollapseApple(Point head) {
        for (Point apple : apples) {
            if (head.x == apple.x && head.y == apple.y) {
                apples.remove(apple);
                return true;
            }
        }
        return false;
    }
}
