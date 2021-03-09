package kakao.blind_2020_first_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        List<Integer> answer = new ArrayList<>();

        int rowSize = relation.length;
        int colSize = relation[0].length;

        for (int k = 1; k < (1 << colSize); k++) {
            Set<List<String>> set = new HashSet<>();

            for (int i = 0; i < rowSize; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < colSize; j++) {
                    if ((k & (1 << j)) > 0) {
                        list.add(relation[i][j]);
                    }
                }
                set.add(list);
            }

            if(set.size() == rowSize && possible(answer, k)) {
                answer.add(k);
            }
        }
        return answer.size();
    }

    private boolean possible(List<Integer> answer, int k) {
        for (Integer i : answer) {
            if((i & k) == i) {
                return false;
            }
        }
        return true;
    }
}