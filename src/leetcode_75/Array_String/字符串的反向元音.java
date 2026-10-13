package leetcode_75.Array_String;

public class 字符串的反向元音 {

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println("最后结果：" + reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        System.out.println("初始s " + s);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        System.out.println("初始left = " + left + ", right = " + right);
        while (left < right) {

            System.out.println("当前轮left = " + left + ",当前轮right = " + right);

            // 右边不是元音，向右移动
            if (!isVowel(chars[left])) {
                left++;
                continue;
            }
            // 右边不是元音，向左移动
            if (!isVowel(chars[right])) {
                right--;
                continue;
            }
            System.out.println("要执行交换了");
            // 两边都是元音，交换位置
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;

        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

}
