package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13460 implements ProblemInterface {

    private static final int EMPTY = '.';
    private static final int WALL = '#';
    private static final int HOLE = 'O';

    private static final int[][] DIRECTION = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static boolean[][][][] visited;
    private static int[][] map;

    private static class Node {

        Point redBall;
        Point blueBall;
        int depth;

        public Node(Point redBall, Point blueBall, int depth) {
            this.redBall = redBall;
            this.blueBall = blueBall;
            this.depth = depth;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        Point redBall = new Point();
        Point blueBall = new Point();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'B') {
                    blueBall = new Point(i, j);
                    map[i][j] = EMPTY;
                    continue;
                }
                if (line.charAt(j) == 'R') {
                    redBall = new Point(i, j);
                    map[i][j] = EMPTY;
                    continue;
                }
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[N][M][N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(redBall, blueBall, 0));
        setVisit(redBall, blueBall);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int[] direction : DIRECTION) {
                Point movedRedBall = move(node.redBall, direction);
                Point movedBlueBall = move(node.blueBall, direction);

                if (isHole(movedBlueBall)) {
                    continue;
                }

                if (isHole(movedRedBall)) {
                    System.out.print(node.depth + 1);
                    return;
                }

                if (movedRedBall.equals(movedBlueBall)) {
                    if (getDistance(node.redBall, movedRedBall) > getDistance(node.blueBall,
                        movedBlueBall)) {
                        movedRedBall.x -= direction[0];
                        movedRedBall.y -= direction[1];
                    } else {
                        movedBlueBall.x -= direction[0];
                        movedBlueBall.y -= direction[1];
                    }
                }

                if (!isVisit(movedRedBall, movedBlueBall) && node.depth < 9) {
                    queue.add(new Node(movedRedBall, movedBlueBall, node.depth + 1));
                    setVisit(movedRedBall, movedBlueBall);
                }
            }
        }

        System.out.print(-1);
    }

    private static boolean isNextWall(Point point, int[] direction) {
        return map[point.x + direction[0]][point.y + direction[1]] == WALL;
    }

    private static boolean isHole(Point point) {
        return map[point.x][point.y] == HOLE;
    }

    private static Point move(Point point, int[] direction) {
        Point result = new Point(point);
        while (!isNextWall(result, direction) && !isHole(result)) {
            result.x += direction[0];
            result.y += direction[1];
        }
        return result;
    }

    private static int getDistance(Point p, Point q) {
        return Math.abs(p.x - q.x) + Math.abs(p.y - q.y);
    }

    private static boolean isVisit(Point p, Point q) {
        return visited[p.x][p.y][q.x][q.y];
    }

    private static void setVisit(Point p, Point q) {
        visited[p.x][p.y][q.x][q.y] = true;
    }
}
