import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        boolean isPos = true;
        int answer[] = new int[2];
        int index = 1;
        int people[] = new int[n];
        people[0]++;
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            people[index]++;
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || list.contains(words[i])) {
                isPos = false;
                break;
            }
            list.add(words[i]);
            index = (index + 1) % n;
        }

        if (isPos) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = index+1;
            answer[1] = people[index];
        }

        return answer;
    }
}