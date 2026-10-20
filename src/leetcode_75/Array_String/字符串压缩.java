package leetcode_75.Array_String;

public class 字符串压缩 {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = compress(chars);

        System.out.println("压缩长度：" + length);
        System.out.println("压缩结果：" +
                new String(chars, 0, length));
    }

    public static int compress1(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            // 统计连续相同字符的数量
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            // 添加字符
            sb.append(current);
            // 出现多次才添加数量
            if (count > 1) {
                System.out.println("次数多少次：" + count);
                sb.append(count);
            }

        }
        // 将结果写回原数组
        for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }
        return sb.length();

    }

    public static int compress(char[] chars) {
        int read = 0;
        int write = 0;

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            // 统计连续相同字符的数量
            while (read < chars.length && chars[read] == current) {
                count++;
                read++;
            }

            // 写入当前字符
            chars[write] = current;
            write++;

            // 如果重复次数大于1，写入次数
            if (count > 1) {
                String num = String.valueOf(count);

                for (int i = 0; i < num.length(); i++) {
                    chars[write] = num.charAt(i);
                    write++;
                }
            }
        }

        return write;
    }
}
