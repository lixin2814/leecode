package juzhen;

public class test73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean row = false, col = false;
            // 检查第一行是否有0
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    row = true;
                    break;
                }
            }
            // 检查第一列是否有0
            for (int i = 0; i < matrix.length; i++) {

                if (matrix[i][0] == 0) {
                    if (matrix[i][0] == 0) {
                        col = true;
                        break;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0 ){
                    for (int j = 1; j < matrix[0].length; j++){
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0){
                    for (int i = 1; i < matrix.length; i++){
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row) {
                for (int j = 0; j < matrix[0].length; j++){
                    matrix[0][j] = 0;
                }
            }
            if (col) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
