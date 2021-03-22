import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int count = 0;
        int[] score = new int[3];

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                if (dartResult.charAt(i + 1) == '0') {
                    score[count] = 10;
                    i++;
                    continue;
                }
                int x = Integer.parseInt(String.valueOf(c));
                score[count] = x;
            }
            else if (Character.isLetter(c)) {
                if (c == 'D') {
                    score[count] = (int)Math.pow(score[count], 2);
                }
                else if (c == 'T') {
                    score[count] = (int)Math.pow(score[count], 3);
                }
                count++;
            }
            else {
                if (c == '*') {
                    score[count - 1] *= 2;
                    if (count >= 2) {
                        score[count - 2] *= 2;
                    }
                }
                else {
                    score[count - 1] *= -1;
                }
            }
        }
        
        return Arrays.stream(score).sum();
    }
}