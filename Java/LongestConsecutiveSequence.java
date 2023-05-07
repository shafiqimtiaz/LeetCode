import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int n : nums) set.add(n);
        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int length = 0;
                while (set.contains(n + length)) length++;
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) s.add(i);
        int max = 0;

        for (int i : s) {
            if (s.contains(i + 1)) continue;
            int count = 0;
            while (s.contains(i - ++count)) ;
            max = Math.max(max, count);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] arr2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        assert longestConsecutive1(arr1) == 4;
        assert longestConsecutive2(arr2) == 9;
        System.out.println(longestConsecutive1(arr1));
        System.out.println(longestConsecutive2(arr2));

    }
}
