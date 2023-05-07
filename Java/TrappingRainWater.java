public class TrappingRainWater {

    public static int trapBF(int[] height) {
        int sum = 0;
        int n = height.length;
        if (n <= 2) return 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            int right = 0;
            for (int j = i; j < n; j++) {
                right = Math.max(right, height[j]);
            }
            sum += Math.min(left, right) - height[i];
        }
        return sum;
    }

    public static int trapDP(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static int trapTP(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int sum = 0, l = 0, r = n - 1;
        int lMax = height[l], rMax = height[r];

        while (l < r) {
            if (lMax < rMax) {
                sum += lMax - height[l];
                l++;
                lMax = Math.max(lMax, height[l]);
            } else {
                sum += rMax - height[r];
                r--;
                rMax = Math.max(rMax, height[r]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] pillars = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trapBF(pillars));
        System.out.println(trapDP(pillars));
        System.out.println(trapTP(pillars));
    }
}
