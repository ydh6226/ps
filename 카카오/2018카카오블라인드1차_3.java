import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String cityName : cities) {
            String city = cityName.toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
                continue;
            }

            if (cache.size() == cacheSize) {
                cache.remove(0);
            }
            cache.add(city);
            answer += 5;
        }
        return answer;
    }
}