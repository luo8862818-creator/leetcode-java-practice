package leetcode_75_Two_Pointers;

public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2};
        System.out.println(maxArea(height));
    }

    public static int maxArea1(int[] height) {
        int max = 0;

        // 第一层循环：选择左边的竖线
        for (int i = 0; i < height.length - 1; i++) {

            // 第二层循环：选择右边的竖线
            for (int j = i + 1; j < height.length; j++) {

                // 计算容器宽度
                int width = j - i;

                // 容器高度由较短的竖线决定
                int h = Math.min(height[i], height[j]);

                // 计算面积
                int area = width * h;

                // 更新最大面积
                max = Math.max(max, area);
            }
        }

        return max;
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            max = Math.max(max, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
