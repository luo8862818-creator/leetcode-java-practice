package leetcode_75.Array_String;

/*
给定两个字符串 Aword1和word2B。将这两个字符串合并，从 A 开始，交替添加字母word1。
如果一个字符串比另一个字符串长，则将添加的字母附加到合并后的字符串的末尾。

例1：

输入： word1 = "abc", word2 = "pqr"
输出： "apbqcr"
说明： 合并后的字符串将按如下方式合并：
单词1：abc
word2：pqr
已合并：apbqcr
例2：

输入： word1 = "ab", word2 = "pqrs"
输出： "apbqrs"
说明： 注意，由于 word2 更长，因此在末尾添加了 "rs"。
word1：ab
word2：pqrs
已合并：apbqrs
例3：

输入： word1 = "abcd", word2 = "pq"
输出： "apbqcd"
说明： 注意，由于 word1 较长，因此在末尾添加了 "cd"。
单词1：abcd
word2：pq
已合并：apbqcd*/
public class 交替合并字符串 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                res.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                res.append(word2.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        交替合并字符串 c = new 交替合并字符串();
        System.out.println(c.mergeAlternately("abcd", "pq"));

    }

}
