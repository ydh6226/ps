import java.util.PriorityQueue;

class Solution {

    int[] root;

    public int solution(int n, int[][] costs) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] cost : costs) {
            pq.add(new Node(cost[0], cost[1], cost[2]));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (getRoot(node.x) != getRoot(node.y)) {
                union(node.x, node.y);
                answer += node.c;
            }
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int c;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.c = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }

    private int getRoot(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = getRoot(root[x]);
    }

    private void union(int x, int y) {
        int a = getRoot(x);
        int b = getRoot(y);
        root[a] = b;
    }
}