public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int minOfTwo = Math.min(height[left], height[right]);
            int gap = right - left;
            int water = minOfTwo * gap;
            maxArea = Math.max(maxArea, water);

            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] pillars = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(pillars));
    }
}
