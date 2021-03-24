import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<List<String>, List<Integer>> map = new HashMap<>();

        for (String s : info) {
            List<String> tmp = Arrays.asList(s.split(" "));

            List<String> select = tmp.subList(0, tmp.size() - 1);
            int score = Integer.parseInt(tmp.get(tmp.size() - 1));

            List<List<String>> keys = new ArrayList<>();
            geyKeys(select, new ArrayList<>(), 0, keys);

            for (List<String> key : keys) {
                if (map.containsKey(key)) {
                    List<Integer> list = map.get(key);
                    list.add(score);
                    continue;
                }
                map.put(key, new ArrayList<>() {{
                    add(score);
                }});
            }
            System.out.println();
        }

        for (Map.Entry<List<String>, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        int idx = 0;
        int[] answer = new int[query.length];
        for (String s : query) {
            List<String> tmp = Arrays.asList(s.replaceAll(" and ", " ").split(" "));

            List<String> select = tmp.subList(0, tmp.size() - 1);
            int score = Integer.parseInt(tmp.get(tmp.size() - 1));

            if (!map.containsKey(select)) {
                answer[idx++] = 0;
                continue;
            }

            List<Integer> scores = map.get(select);
            int result = lowerBound(scores, score);
            answer[idx++] = scores.size() - result;
        }
        return answer;
    }

    private void geyKeys(List<String> input, List<String> result, int idx, List<List<String>> ret) {
        if (idx == 4) {
            ret.add(result);
            return;
        }

        for (int i=0; i<2; i++){
            String select;
            if (i == 0)
                select = input.get(idx);
            else
                select = "-";

            result.add(select);
            geyKeys(input, new ArrayList<>(result), idx + 1, ret);
            result.remove(result.size() - 1);
        }
    }

    private int lowerBound(List<Integer> array, int key) {
        int left = 0;
        int right = array.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (array.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}