import java.util.*;

class Solution {
    int[][] map;

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        map = board;
        List<Integer> blocks = new ArrayList<>();

        for (int move : moves) {
            int top = getTop(move - 1);
            System.out.println("top = " + top);
            if (top == 0) {
                continue;
            }

            blocks.add(top);

            if (blocks.size() >= 2) {
                int size = blocks.size();
                if (blocks.get(size - 1).equals(blocks.get(size - 2))) {
                    blocks.remove(size - 1);
                    blocks.remove(size - 2);
                    answer += 2;
                }
            }
        }
        return answer;
    }

    private int getTop(int move) {
        for (int i = 0; i < map.length; i++) {
            if (map[i][move] != 0) {
                int tmp = map[i][move];
                map[i][move] = 0;
                return tmp;
            }
        }
        return 0;
    }
}

class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 0, 0, 0,0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    }
}