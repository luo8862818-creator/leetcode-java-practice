package leetcode_75_hash_map_set;

import java.util.*;

public class 确定两个字符串是否接近 {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        closeStrings(word1, word2);

    }
    public static boolean closeStrings1(String word1, String word2) {

        // 1. 判断长度
        if (word1.length() != word2.length()) {
            return false;
        }

        // 2. 获取两个字符串的字符集合
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (int i = 0; i < word1.length(); i++) {
            set1.add(word1.charAt(i));
        }

        for (int i = 0; i < word2.length(); i++) {
            set2.add(word2.charAt(i));
        }

        // 3. 判断字符种类是否相同
        if (!set1.equals(set2)) {
            return false;
        }

        // 4. 统计字符出现次数
        List<Integer> freq1 = new ArrayList<>();
        List<Integer> freq2 = new ArrayList<>();

        for (char c : set1) {
            int count = 0;

            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) == c) {
                    count++;
                }
            }

            freq1.add(count);
        }

        for (char c : set2) {
            int count = 0;

            for (int i = 0; i < word2.length(); i++) {
                if (word2.charAt(i) == c) {
                    count++;
                }
            }

            freq2.add(count);
        }

        // 5. 排序
        Collections.sort(freq1);
        Collections.sort(freq2);

        // 6. 比较出现次数
        return freq1.equals(freq2);
    }

    public static boolean closeStrings(String word1, String word2) {

        // 1. 判断长度
        if (word1.length() != word2.length()) {
            return false;
        }

        // 2. 创建频率数组
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // 3. 统计字符出现次数
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
        }

        // 4. 判断字符种类是否相同
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0) != (freq2[i] == 0)) {
                return false;
            }
        }

        // 5. 排序
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // 6. 比较频率
        return Arrays.equals(freq1, freq2);
    }
}
