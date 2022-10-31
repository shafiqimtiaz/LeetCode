import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0, 3, 1};
        int[] arr2 = new int[]{0, 1, 0, 0, 9};
        int[] arr3 = new int[]{0, 1, 0};

        moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));
        moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
        moveZeroes(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
