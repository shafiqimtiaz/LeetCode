import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] left_prod = new int[n];
        int[] right_prod = new int[n];

        int[] output = new int[n];

        left_prod[0] = 1;
        right_prod[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left_prod[i] = left_prod[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right_prod[i] = right_prod[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left_prod[i] * right_prod[i];
        }
        return output;
    }

    public static int[] productExceptSelf_better(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int right = 1, left = 1;
        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf_better(nums)));
    }
}
