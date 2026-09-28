package leetcode_75.Array_String;
/*对于两个字符串sa 和 b t，我们说“t除以 a s”当且仅当s = t + t + t + ... + t + tat与自身连接一次或多次。

给定两个字符串str1a 和str2b，返回能同时整除 a和 b 的最大字符串。xxstr1str2



例1：

输入： str1 = "ABCABC", str2 = "ABC"

输出： “ABC”

例2：

输入： str1 = "ABABAB", str2 = "ABAB"

输出： “AB”

例3：

输入： str1 = "LEET", str2 = "CODE"

输出： ””

例 4：

输入： str1 = "AAAAAB", str2 = "AAA"

输出： " "*/
public class 字符串的最大公约数 {
    public String gcdOfStrings(String str1, String str2) {
        // 如果两个字符串不是由同一种基本字符串重复组成
        // 那么无论如何都不存在公约字符串
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        System.out.println("str1 + str2 = " + str1 + str2);
        System.out.println("str2 + str1 = " + str2 + str1);
        // 求两个字符串长度的最大公约数
        int length =  gcd2(str1.length(), str2.length());
        // 截取最大公约数长度的字符串
        return str1.substring(0, length);
    }

    //求最大公约数
    private int gcd(int a, int b) {
        System.out.println("a的长度： " + a);
        System.out.println("b的长度： " + b);
        int count = 0;
        while (b!=0) {
            count++;
            System.out.println("第" + count + "次循环");
            int temp = a % b;
            System.out.println("当前第" + count + "次循环 temp = " + temp);
            a = b;
            b = temp;
            System.out.println("当前第" + count + "次循环 a = " + a);
            System.out.println("当前第" + count + "次循环 b = " + b);
        }
        return a;
    }

    private int gcd2(int a, int b) {
        int min = Math.min(a, b);
        System.out.println("min的值是多少呀 " + min);

        for (int i = min; i > 0; i--) {
            System.out.println("i的值是多少 " + i);
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        字符串的最大公约数 res = new 字符串的最大公约数();
        System.out.println("最后的结果是：" + res.gcdOfStrings("ABABAB", "ABAB"));
    }
}
