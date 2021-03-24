import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] split = s.substring(2, s.length() - 2).split("},\\{");
        Set<String> set = new HashSet<>();

        int idx = 0;
        int[] answer = new int[split.length];
        Arrays.sort(split, Comparator.comparingInt(String::length));
        for (String str : split) {
            for (String num : str.split(",")) {
                if (set.add(num))
                    answer[idx++] = Integer.parseInt(num);
            }
        }
        return answer;
    }
}
