class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;

        for (int i = 1; i <= len / 2; i++) {
            String substr = "";
            int idx = 0;
            int count = 1;
            int ans = 0;

            while (idx < len) {
                int end = Math.min(idx + i, len);

                if (s.substring(idx, end).equals(substr)) {
                    count++;
                } else {
                    ans += substr.length();
                    if (count != 1) {
                        ans += String.valueOf(count).length();
                    }

                    substr = s.substring(idx, end);
                    count = 1;
                }
                idx += i;
            }

            ans += substr.length();
            if (count != 1) {
                ans += String.valueOf(count).length();
            }

            answer = Math.min(answer, ans);
        }
        return answer;
    }
}