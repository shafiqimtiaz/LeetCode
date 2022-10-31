public class BinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1, 0, 3, 5, 9, 12};
        int[] arr2 = new int[]{0, 1, 1, 2, 9};

        System.out.println(search(arr1, 9));
        System.out.println(search(arr2, 1));
    }
}
