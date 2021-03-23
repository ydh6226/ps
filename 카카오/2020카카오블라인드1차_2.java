class Solution {
    public String solution(String p) {
        if (p.isEmpty() || isCorrect(p))
            return p;

        String u = "", v = "";

        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            count += p.charAt(i) == '(' ? 1 : -1;
            if (count == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (isCorrect(u))
            return u + solution(v);

        String tmp = "(" + solution(v) + ")";

        for (int i = 1; i < u.length() - 1; i++) {
             tmp += u.charAt(i) == ')'? '(' : ')';
        }
        return tmp;
    }

    private boolean isCorrect(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += str.charAt(i) == '(' ? 1 : -1;
            if (count < 0)
                return false;
        }
        return true;
    }
}