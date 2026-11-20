package leetcode_75_hash_map_set;

import java.util.*;

public class 唯一出现次数 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,3};
        uniqueOccurrences(nums);
    }
    public static boolean uniqueOccurrences1(int[] arr) {

        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // 判断当前数字之前是否统计过
            boolean exists = false;

            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    exists = true;
                    break;
                }
            }

            // 已经统计过，跳过
            if (exists) {
                continue;
            }

            // 统计当前数字出现的次数
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // 判断出现次数是否重复
            for (int num : counts) {
                if (num == count) {
                    return false;
                }
            }

            // 保存出现次数
            counts.add(count);
        }

        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                continue;
            }

            int count = 0;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] == arr[i]) {
                    count++;
                }
            }

            for (int num : counts) {
                if (num == count) {
                    return false;
                }
            }

            counts.add(count);
        }
        return true;
    }

    public static boolean uniqueOccurrences(int[] arr) {

        // 1. 使用 HashMap 统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 使用 HashSet 判断出现次数是否重复
        Set<Integer> set = new HashSet<>();

        for (int count : map.values()) {

            if (!set.add(count)) {
                return false;
            }
        }

        return true;
    }
}
