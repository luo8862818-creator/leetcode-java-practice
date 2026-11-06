package leetcode_75_Sliding_Window;

public class 定长子串中元音的最大数目 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("个数：" + maxVowels(s, 3));
    }

    public static int maxVowels1(String s, int k) {

        int maxCount = 0;

        for (int i = 0; i <= s.length() - k; i++) {
            System.out.println("当前i：" + i);
            int count = 0;

            for (int j = i; j < i + k; j++) {
                System.out.println("当 i = " + i + ", j = " + j);

                char c = s.charAt(j);

                if (isVowel(c)) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }



    public static int maxVowels(String s, int k) {

        int count = 0;

        // 1. 统计第一个窗口
        for (int i = 0; i < k; i++) {
            System.out.println("第一个窗口: " + i);
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int maxCount = count;


        System.out.println("开始滑动窗口————————————————————————————");
        // 2. 开始滑动窗口
        for (int i = k; i < s.length(); i++) {
            System.out.println("当前轮i的值是：" + i);
            System.out.println("当前轮count = " + count);
            System.out.println("-------------------------");

            int sum = count;
            // 移除窗口左边的字符
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            if (sum > count) {
                System.out.println("去除左边元素");
                System.out.println("------------------------------");
            }


            // 加入窗口右边的新字符
            if (isVowel(s.charAt(i))) {
                count++;
            }


            // 更新最大元音数量
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }


    private static boolean isVowel(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }
}
