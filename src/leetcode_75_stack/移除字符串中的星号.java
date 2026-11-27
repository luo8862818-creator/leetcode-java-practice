package leetcode_75_stack;

public class 移除字符串中的星号 {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        removeStars(s);
    }
    public static String removeStars1(String s) {

        StringBuilder sb = new StringBuilder(s);

        while (true) {

            // 1. 找到第一个星号
            int starIndex = sb.indexOf("*");

            // 2. 没有星号，结束循环
            if (starIndex == -1) {
                break;
            }

            // 3. 从星号左边开始查找
            int j = starIndex - 1;

            // 4. 跳过星号，找到最近的有效字符
            while (j >= 0 && sb.charAt(j) == '*') {
                j--;
            }

            // 5. 删除当前星号
            sb.deleteCharAt(starIndex);

            // 6. 删除左边最近的有效字符
            sb.deleteCharAt(j);
        }

        return sb.toString();
    }

    public static String removeStars(String s) {

        // 使用 StringBuilder 模拟栈
        StringBuilder stack = new StringBuilder();

        // 遍历字符串
        for (char c : s.toCharArray()) {

            // 如果是普通字符，入栈
            if (c != '*') {
                stack.append(c);
            }
            // 如果是星号，删除栈顶元素
            else {
                stack.deleteCharAt(stack.length() - 1);
            }
        }

        return stack.toString();
    }
}
