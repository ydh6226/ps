import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    String[][] ticket;
    boolean[] visit;
    int size;
    String[] answer;

    public String[] solution(String[][] tickets) {
        size = tickets.length;
        visit = new boolean[size];
        ticket = tickets;

        answer = new String[size + 1];
        Arrays.fill(answer, "ZZZ");

        for (int i = 0; i < size; i++) {
            if (tickets[i][0].equals("ICN")) {
                visit[i] = true;
                String[] path = {tickets[i][0], tickets[i][1]};
                dfs(path);
                visit[i] = false;
            }
        }
        return answer;
    }

    private void dfs(String[] path) {
        if (path.length == size + 1) {
            if (isPrecede(path, answer)) {
                answer = path;
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!visit[i] && ticket[i][0].equals(path[path.length - 1])) {
                visit[i] = true;

                String[] tmp = new String[path.length + 1];
                System.arraycopy(path, 0, tmp, 0, path.length);
                tmp[tmp.length - 1] = ticket[i][1];
                dfs(tmp);
                visit[i] = false;
            }
        }

    }

    private boolean isPrecede(String[] source, String[] target) {
        for (int i = 0; i < size; i++) {
            if (source[i].compareTo(target[i]) < 0) {
                return true;
            } else if (source[i].compareTo(target[i]) > 0) {
                return false;
            }
        }
        return false;
    }
}