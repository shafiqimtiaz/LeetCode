import java.util.*;

public class IntersectionOfTwoArraysII {

    public static int[] intersectMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] intersect2Pointer(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        while (k < list.size()) {
            res[k] = list.get(k);
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 9, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect2Pointer(arr1, arr2)));
        System.out.println(Arrays.toString(intersectMap(arr1, arr2)));
    }
}
