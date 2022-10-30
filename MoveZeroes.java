import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int l = 0, r = 1;
        while (r < nums.length - 1) {
            if (nums[l] != nums[r] && (nums[l] == 0 || nums[r] == 0)) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            } else if (nums[l] == nums[r]) {
                l++;
                r++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0, 3, 1};
        int[] arr2 = new int[]{0, 1, 0, 0, 9};
        int[] arr3 = new int[]{0, 0};

        moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));
        moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
        moveZeroes(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
