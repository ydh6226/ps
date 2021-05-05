import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int size = set.size();

        Map<String, Integer> gemMap = new HashMap<>();
        List<String> gemList = new ArrayList<>();

        int[] answer = {0, 0};
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = -1;
        while (true) {
            if (gemMap.size() == size) {
                int len = right - left;
                if (minLen > len) {
                    minLen = len;
                    answer = new int[]{left + 1, right  + 1};
                }
            }

            if (gemMap.size() < size) {
                if (right + 1 == gems.length) {
                    break;
                }

                String gem = gems[++right];
                gemList.add(gem);
                gemMap.put(gem, gemMap.getOrDefault(gem, 0) + 1);

                for (int i = 0; i < gemList.size() - 1 ; i++) {
                    String curGem = gemList.get(i);
                    if (gemMap.get(curGem) > 1) {
                        gemList.remove(i--);
                        gemMap.put(curGem, gemMap.get(curGem) - 1);
                        left++;
                    } else {
                        break;
                    }
                }
            } else {
                gemList.remove(0);
                String curGem = gems[left];
                if (gemMap.get(curGem) > 1) {
                    gemMap.put(curGem, gemMap.get(curGem) - 1);
                } else {
                    gemMap.remove(curGem);
                }
                left++;
            }
        }
        return answer;
    }
}