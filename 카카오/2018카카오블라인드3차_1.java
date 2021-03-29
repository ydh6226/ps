class Solution {
    char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int size = t * m;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            sb.append(getNumber(i, n));
            if (sb.length() >= size) {
                break;
            }
        }

        String allNumber = sb.toString();
        for (int i = p -1 ; i < size ; i+=m) {
            answer.append(allNumber.charAt(i));
        }

        return answer.toString();
    }

    private String getNumber(int x, int n) {
        StringBuilder sb = new StringBuilder();
        while (x / n != 0) {
            sb.append(map[x % n]);
            x = x / n;
        }
        sb.append(map[x % n]);
        return sb.reverse().toString();
    }
}