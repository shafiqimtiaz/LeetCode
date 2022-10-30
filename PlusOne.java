import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] new_num = new int[n + 1];
        new_num[0] = 1;

        return new_num;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{9};
        int[] arr2 = new int[]{1, 9};
        int[] arr3 = new int[]{6, 7, 8, 9};

        System.out.println(Arrays.toString(plusOne(arr1)));
        System.out.println(Arrays.toString(plusOne(arr2)));
        System.out.println(Arrays.toString(plusOne(arr3)));
    }
}
