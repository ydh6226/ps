class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");

        if (answer.isEmpty())
            answer += "a";

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("^[.]|[.]$", "");
        }

        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
}

class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("...!@BaT#*..y.abcdefghijklm");

    }
}