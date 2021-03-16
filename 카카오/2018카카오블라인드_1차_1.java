class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int a = arr1[i];
            int b = arr2[i];
            int result = a|b;

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (((result >> j) & 1) == 1) {
                    sb.append("#");
                    continue;
                }
                sb.append(" ");
            }
            String tmp = sb.reverse().toString();
            answer[i] = tmp;
        }
        return answer;
    }
}