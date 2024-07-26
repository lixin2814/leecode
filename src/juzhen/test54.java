package juzhen;

import java.util.ArrayList;
import java.util.List;

public class test54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int top= 0, bottom = matrix.length - 1,left = 0, right = matrix[0].length - 1;
            List<Integer> res = new ArrayList<>();
            while(true) {
                //从左到右
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
                if(top > bottom) break;
                //从上到下
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                if(left > right) break;
                //从右到左
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                if(top > bottom) break;
                //从下到上
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                if(left > right) break;
            }

            return  res;
        }
    }
}

