import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    public static void permute(int[] nums, int index, List<List<Integer>> resList) {

        if (index == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            resList.add(res);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swapArr(nums, index, i);
            permute(nums, index + 1, resList);
            swapArr(nums, index, i);
        }
    }

    public static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

