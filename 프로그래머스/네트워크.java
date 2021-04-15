import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] root;

    public int solution(int n, int[][] computers) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < computers.length - 1; i++) {
            for (int j = i + 1; j < computers.length; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int x : root) {
            set.add(find(x));
        }
        return set.size();
    }

    private int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        root[a] = root[b];
    }
}