import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!list.isEmpty() && list.get(list.size() -1) < c && --k >= 0) {
                list.remove(list.size() - 1);
            }
            list.add(c);
        }

        for (int i = 0; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        return String.valueOf(answer);
    }
}