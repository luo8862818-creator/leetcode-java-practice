package leetcode_75_Two_Pointers;

public class 是子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdd"));
    }
    public static boolean isSubsequence1(String s, String t) {
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean found = false;

            for (int j = start; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    start = j + 1;
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }


    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
