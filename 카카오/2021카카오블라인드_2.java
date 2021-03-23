import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();

        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            for (int x : course) {
                Map<String, Integer> tmp = map.getOrDefault(x, new HashMap<>());
                combination(sortedStr, "", 0, x , tmp);

                if (!tmp.isEmpty())
                    map.put(x, tmp);
            }
        }

        for (int x : course) {
            if (map.containsKey(x)) {
                Map<String, Integer> tmp = map.get(x);
                int max = Math.max(2, Collections.max(tmp.values()));

                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    if (entry.getValue().equals(max)){
                        answer.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(answer);
        String[] ans = new String[answer.size()];

        int idx = 0;
        for (String s : answer) {
            ans[idx++] = s;
        }
        return ans;
    }

    private void combination(String input, String result, int start, int size, Map<String, Integer> map) {
        if (result.length() == size) {
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }

        for (int i = start; i < input.length(); i++) {
            combination(input, result + input.charAt(i), i + 1, size, map);
        }
    }
}