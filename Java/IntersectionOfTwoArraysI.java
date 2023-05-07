import java.util.*;

public class IntersectionOfTwoArraysI {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums1) set.add(n);
        for (int n : nums2) {
            if (set.contains(n))
                if (!list.contains(n))
                    list.add(n);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 9, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
