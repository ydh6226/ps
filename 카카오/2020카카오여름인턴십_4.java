import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] board) {
        int size = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] visit = new int[size][size];

        for (int[] v : visit) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        Queue<Car> queue = new LinkedList<>();
        queue.add(new Car(0, 0, 0, 0, 0));
        visit[0][0] = 0;

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Car car = queue.poll();
            if (car.x == size - 1 && car.y == size - 1) {
                answer = Math.min(answer, car.value);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = car.x + dx[i];
                int ny = car.y + dy[i];
                int nValue = car.value + 100;

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || board[nx][ny] == 1 || visit[nx][ny] < nValue) {
                    continue;
                }

                if (car.ox != nx && car.oy != ny) {
                    nValue += 500;
                }

                queue.add(new Car(nx, ny, car.x, car.y, nValue));
                visit[nx][ny] = nValue;
            }
        }
        return answer;
    }

    private static class Car {
        int x, ox;
        int y, oy;
        int value;

        public Car(int x, int y, int ox, int oy, int value) {
            this.x = x;
            this.y = y;
            this.ox = ox;
            this.oy = oy;
            this.value = value;
        }
    }

}
