import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[k];

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int i : map.keySet()) pq.offer(i);
        for (int i = 0; i < k; i++) res[i] = pq.poll();

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1, 2, 2, 3};
        int[] arr2 = new int[]{1};
//        int[] arr3 = new int[]{1, 1, 1, 3, 3, 4, 4, 6};

        System.out.println(Arrays.toString(topKFrequent(arr1, 2)));
        System.out.println(Arrays.toString(topKFrequent(arr2, 1)));
//        System.out.println(Arrays.toString(topKFrequent(arr3, 3)));
    }
}
