package leetcode_75.Array_String;

public class 可以摆放鲜花 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        canPlaceFlowers(flowerbed, 1);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            System.out.println("当前位置：" + i);

            // 当前位置已经有花，直接跳过
            if (flowerbed[i] == 1) {
                continue;
            }

            // 第一步：检查左边
            boolean left = false;

            if (i == 0) {
                left = true;
            } else {
                if (flowerbed[i - 1] == 0) {
                    left = true;
                }
            }

            // 第二步：检查右边
            boolean right = false;

            if (i == flowerbed.length - 1) {
                right = true;
            } else {
                if (flowerbed[i + 1] == 0) {
                    right = true;
                }
            }

            // 第三步：左右都满足，种花
            if (left && right) {
                flowerbed[i] = 1;
                n--;
            }

            // 第四步：判断是否种够
            if (n <= 0) {
                return true;
            }
        }

        return n <= 0;
    }
}
