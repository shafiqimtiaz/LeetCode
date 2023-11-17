import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        List<List<Integer>> result = new PermutationsII().permuteUnique(nums);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
