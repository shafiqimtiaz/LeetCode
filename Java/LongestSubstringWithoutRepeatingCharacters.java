import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstringMap(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstringSet(String s) {
        int maxLen = 0;
        Set<Character> window = new HashSet<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            while (window.contains(s.charAt(right)))
                window.remove(s.charAt(left++));
            window.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstringQueue(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c))
                queue.poll();
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringMap("abcabcbb"));
        System.out.println(lengthOfLongestSubstringMap("bbbbb"));
        System.out.println(lengthOfLongestSubstringMap("pwwkew"));
    }
}
