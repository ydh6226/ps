import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        List<Integer> possible = new ArrayList<>();

        for (int i = 1; i < Math.pow(2, relation[0].length); i++) {
            Set<List<String>> set = new HashSet<>();

            boolean isPossible = true;
            for (String[] strings : relation) {
                List<String> current = new ArrayList<>();

                String reverseBinary = new StringBuilder(Integer.toBinaryString(i)).reverse().toString();
                for (int j = 0; j <reverseBinary.length(); j++) {
                    if (reverseBinary.charAt(j) == '1') {
                        current.add(strings[j]);
                    }
                }

                if (!set.add(current)) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible)
                continue;

            isPossible = true;
            for (Integer x : possible) {
                if ((x & i) == x) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible)
                continue;
            possible.add(i);
        }
        return possible.size();
    }
}