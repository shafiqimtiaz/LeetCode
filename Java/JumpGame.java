public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0, n = nums.length, lastIndex = n - 1;
        for (int i = 0; i < n; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return max >= lastIndex;
    }
}
