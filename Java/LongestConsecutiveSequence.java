import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
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

    public static void main(String[] args) {
        int[] arr1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] arr2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        assert longestConsecutive(arr1) == 4;
        assert longestConsecutive(arr2) == 9;
        System.out.println(longestConsecutive(arr1));
        System.out.println(longestConsecutive(arr2));

    }
}
