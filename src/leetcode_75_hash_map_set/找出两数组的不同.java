package leetcode_75_hash_map_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 找出两数组的不同 {
    public static void main(String[] args) {
        /*nums1 = [1, 2, 3, 3]
        nums2 = [1, 1, 2, 2]*/
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};
        findDifference(nums1, nums2);
    }
    public static List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {

        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();

        // 第一次：找 nums1 中 nums2 不存在的数字
        for (int num : nums1) {

            boolean exists = false;

            for (int other : nums2) {
                if (num == other) {
                    exists = true;
                    break;
                }
            }

            // 不存在，并且结果中没有重复
            if (!exists && !answer1.contains(num)) {
                answer1.add(num);
            }
        }

        // 第二次：找 nums2 中 nums1 不存在的数字
        for (int num : nums2) {

            boolean exists = false;

            for (int other : nums1) {
                if (num == other) {
                    exists = true;
                    break;
                }
            }

            if (!exists && !answer2.contains(num)) {
                answer2.add(num);
            }
        }

        // 将两个结果放入二维集合
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(answer1);
        answer.add(answer2);

        return answer;
    }


    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            boolean exits = false;
            for(int num : nums2){
                if (num == nums1[i]) {
                    exits = true;
                    break;
                }
            }
            if (!exits && answer1.contains(nums1[i])) {
                answer1.add(nums1[i]);
            }
        }

        for (int i = 0;i < nums2.length; i++) {
            boolean exits = false;
            for (int num : nums1) {
                if (num == nums2[i]) {
                    exits = true;
                    break;
                }
            }
            if (!exits && answer2.contains(nums2[i])) {
                answer2.add(nums2[i]);
            }

        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(answer1);
        answer.add(answer2);

        return answer;
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // 创建两个集合
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 将 nums1 放入 set1
        for (int num : nums1) {
            set1.add(num);
        }

        // 将 nums2 放入 set2
        for (int num : nums2) {
            set2.add(num);
        }

        // 存储两个结果
        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();

        // 找出 nums1 中 nums2 不存在的数字
        for (int num : set1) {
            if (!set2.contains(num)) {
                answer1.add(num);
            }
        }

        // 找出 nums2 中 nums1 不存在的数字
        for (int num : set2) {
            if (!set1.contains(num)) {
                answer2.add(num);
            }
        }

        // 返回二维集合
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(answer1);
        answer.add(answer2);

        return answer;
    }
}
