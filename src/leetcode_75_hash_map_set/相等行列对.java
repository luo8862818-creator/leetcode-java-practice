package leetcode_75_hash_map_set;

import java.util.HashMap;

public class 相等行列对 {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        equalPairs(grid);
    }
    public static int equalPairs1(int[][] grid) {
        int n = grid.length;
        int count = 0;

        // 遍历每一行
        for (int i = 0; i < n; i++) {


            // 遍历每一列
            for (int j = 0; j < n; j++) {

                boolean equal = true;

                // 比较当前行和当前列
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        equal = false;
                        break;
                    }
                }

                // 如果完全相同，计数
                if (equal) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;

        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("========== 第一步：存储每一行 ==========");

        // 1. 遍历每一行
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }

            String key = sb.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);

            System.out.println("第 " + i + " 行：" + key);
            System.out.println("HashMap：" + map);
        }

        System.out.println("\n========== 第二步：遍历每一列 ==========");

        int count = 0;

        // 2. 遍历每一列
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(",");
            }

            String key = sb.toString();

            System.out.println("\n当前第 " + j + " 列：" + key);

            int matches = map.getOrDefault(key, 0);

            System.out.println("HashMap 查询结果：" + matches);

            count += matches;

            System.out.println("当前累计匹配数量：" + count);
        }

        System.out.println("\n========== 最终结果：" + count + " ==========");

        return count;
    }
}
