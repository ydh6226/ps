import java.util.*;

class Solution {
    boolean[] visit = new boolean[8];
    Set<Integer> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, user_id, banned_id);
        return set.size();
    }

    private void dfs(int idx, String[] user_id, String[] banned_id) {
        if (idx == banned_id.length) {
            int key = 0;
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    key += 1 << i;
                }
            }
            set.add(key);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visit[i] && possible(user_id[i], banned_id[idx])) {
                visit[i] = true;
                dfs(idx + 1, user_id, banned_id);
                visit[i] = false;
            }
        }
    }

    private boolean possible(String user, String ban) {
        if (user.length() != ban.length())
            return false;

        for (int i = 0; i < user.length(); i++) {
            if (!(ban.charAt(i) == user.charAt(i) || ban.charAt(i) == '*')) {
                return false;
            }
        }
        return true;
    }
}