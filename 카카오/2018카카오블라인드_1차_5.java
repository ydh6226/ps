import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        Set<String> set = new HashSet<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        process(s1, map1, set);
        process(s2, map2, set);

        double a = 0, b = 0;
        for (String s : set) {
            long tmpA = map1.getOrDefault(s, 0);
            long tmpB = map2.getOrDefault(s, 0);

            a += Math.min(tmpA, tmpB);
            b += Math.max(tmpA, tmpB);
        }

        if (b == 0)
            return 65536;
        return (int) (a / b * 65536);
    }

    private void process(String s, Map<String, Integer> map, Set<String> set) {
        for (int i = 0; i < s.length() - 1; i++) {
            String substring = s.substring(i, i + 2);
            char first = substring.charAt(0);
            char second = substring.charAt(1);

            if (!(Character.isLetter(first) && Character.isLetter(second))) {
                continue;
            }

            map.put(substring, map.getOrDefault(substring, 0) + 1);
            set.add(substring);
        }
    }
}