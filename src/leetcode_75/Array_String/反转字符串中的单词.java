package leetcode_75.Array_String;

public class 反转字符串中的单词 {
    public static void main(String[] args) {
        String s = " hello world ";
        System.out.println("最后结果：" + reverseWords(s));
    }

    public static String reverseWords(String s) {
        System.out.println(s.length());
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            // 1. 跳过空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // 2. 记录单词结束位置
            int end = i;

            // 3. 向左寻找单词开始位置
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // 4. 添加单词
            if (sb.length() > 0) {
                sb.append(" ");
            }

            System.out.println("end == " + end);
            sb.append(s, i + 1, end + 1);
        }
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        //包含一个或者多个空格
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            System.out.println("i的值：" + i);
            System.out.println("i 没判断之前：" + sb);
            if (i > 0) {
                System.out.println("添加空格");
                sb.append(" ");
            }
            System.out.println("i 判断之后：" + sb);
        }
        return sb.toString();

    }
}
